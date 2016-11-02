// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.daikon.di;

import static org.talend.daikon.di.DiSchemaConstants.TALEND6_COLUMN_TALEND_TYPE;
import static org.talend.daikon.di.IndexMapper.DYNAMIC;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import org.apache.avro.generic.IndexedRecord;
import org.talend.daikon.avro.AvroUtils;
import org.talend.daikon.avro.SchemaConstants;

/**
 * This class acts as a wrapper around an arbitrary Avro {@link IndexedRecord} to transform output avro-styled values to the exact
 * Java objects expected by the Talend 6 Studio (which will copy the fields into a POJO in generated code).
 * <p>
 * A wrapper like this should be attached to an input component, for example, to ensure that its outgoing data meets the
 * Schema constraints imposed by the Studio, including:
 * <ul>
 * <li>Coercing the types of the returned objects to *exactly* the type required by the Talend POJO.</li>
 * <li>Placing all of the unresolved columns between the wrapped schema and the output schema in the Dynamic column.</li>
 * </ul>
 * <p>
 * It extends {@link DiOutgoingSchemaEnforcer} and provides handling for dynamic fields
 */
public class DiOutgoingDynamicSchemaEnforcer {

    /**
     * {@link Schema} which was specified by user during setting component properties (at design time)
     * This schema may contain di-specific properties
     */
    private final Schema designSchema;

    /**
     * A {@link List} of design schema {@link Field}s
     */
    private final List<Field> designFields;

    /**
     * Number of fields in design schema
     */
    private final int designSchemaSize;

    /**
     * A {@link List} of runtime schema {@link Field}s
     */
    private final List<Field> runtimeFields;

    /**
     * Dynamic field position in the design schema. Schema can contain 0 or 1 dynamic columns.
     */
    private final int dynamicFieldPosition;

    /**
     * Contains indexes of dynamic fields (i.e. fields which are present in runtime schema, but are not present in design schema)
     */
    private final List<Integer> dynamicFieldsIndexes;

    /**
     * {@link Schema}, which describes dynamic fields (i.e. fields which are present in runtime schema, but are not present in
     * design schema)
     */
    private Schema dynamicFieldsSchema;

    /**
     * Maps design field indexes to runtime field indexes.
     * Design indexes are keys of this array and runtime indexed are values.
     * -1 value means this index corresponds to dynamic field
     */
    private final int[] indexMap;

    /**
     * {@link IndexedRecord} currently wrapped by this enforcer. This can be swapped out for new data as long as
     * they keep the same schema. This {@link IndexedRecord} contains another {@link Schema} which is called actual or runtime
     * schema.
     */
    private IndexedRecord wrappedRecord;

    /**
     * Constructor sets design schema, its fields and size, runtime schema fields and values related to dynamic fields handling
     * 
     * @param designSchema design schema (specified by user and provided by Di Studio)
     * @param runtimeSchema runtime schema (created by component and included into {@link IndexedRecord} ), actual schema of data
     * @param indexMapper tool, which computes correspondence between design and runtime fields
     */
    public DiOutgoingDynamicSchemaEnforcer(Schema designSchema, Schema runtimeSchema, DynamicIndexMapper indexMapper) {
        this.designSchema = designSchema;
        this.designFields = designSchema.getFields();
        this.designSchemaSize = designFields.size();

        this.runtimeFields = runtimeSchema.getFields();

        this.indexMap = indexMapper.computeIndexMap();
        this.dynamicFieldsIndexes = indexMapper.computeDynamicFieldsIndexes();

        if (AvroUtils.isIncludeAllFields(designSchema)) {
            this.dynamicFieldPosition = Integer.valueOf(designSchema.getProp(DiSchemaConstants.TALEND6_DYNAMIC_COLUMN_POSITION));
        } else {
            throw new IllegalArgumentException("Design schema doesn't contain dynamic field");
        }

        createDynamicFieldsSchema(indexMapper);
    }

    // TODO move to parent class
    // @Override
    public Schema getSchema() {
        return designSchema;
    }

    // @Override
    public Schema getDynamicFieldsSchema() {
        return dynamicFieldsSchema;
    }

    /**
     * Wraps {@link IndexedRecord}
     * 
     * @param record {@link IndexedRecord} to be wrapped
     */
    // TODO move to parent class
    // @Override
    public void setWrapped(IndexedRecord record) {
        wrappedRecord = record;
    }

    /**
     * {@inheritDoc}
     * 
     * Could be called only after first record was wrapped
     * 
     * @param pojoIndex index of required value. Could be from 0 to designSchemaSize
     */
    // @Override
    public Object get(int pojoIndex) {
        if (pojoIndex > designSchemaSize) {
            throw new IndexOutOfBoundsException("index should be from 0 to design schema size, but was " + pojoIndex);
        }

        int runtimeIndex = indexMap[pojoIndex];
        if (runtimeIndex == DYNAMIC) {
            return getDynamicValues();
        }

        Field designField = pojoIndex > dynamicFieldPosition ? designFields.get(pojoIndex - 1) : designFields.get(pojoIndex);
        Object value = wrappedRecord.get(runtimeIndex);
        return transformValue(value, designField);
    }

    /**
     * Retrieves dynamic fields values and returns them as map.
     * Map key is dynamic field name
     * Map value is dynamic field value, transformed to Talend type
     * 
     * @return map with dynamic values
     */
    private Map<String, Object> getDynamicValues() {
        Map<String, Object> dynamicValues = new LinkedHashMap<>();
        for (int dynamicIndex : dynamicFieldsIndexes) {
            Field dynamicField = runtimeFields.get(dynamicIndex);
            String dynamicFieldName = dynamicField.name();
            Object value = wrappedRecord.get(dynamicIndex);
            Object transformedValue = transformValue(value, dynamicField);
            dynamicValues.put(dynamicFieldName, transformedValue);
        }
        return dynamicValues;
    }

    /**
     * Transforms record column value from Avro type to Talend type
     * 
     * @param value record column value, which should be transformed into Talend compatible value.
     * It can be null when null
     * corresponding wrapped field.
     * @param designField design field, it should contain information about value's Talend type. It mustn't be null
     */
    // TODO: move it to parent class
    private Object transformValue(Object value, Field designField) {

        if (null == value) {
            return null;
        }

        String talendType = designField.getProp(TALEND6_COLUMN_TALEND_TYPE);
        String javaClass = AvroUtils.unwrapIfNullable(designField.schema()).getProp(SchemaConstants.JAVA_CLASS_FLAG);

        // TODO(rskraba): A full list of type conversion to coerce to Talend-compatible types.
        if ("id_Short".equals(talendType)) {
            return value instanceof Number ? ((Number) value).shortValue() : Short.parseShort(String.valueOf(value));
        } else if ("id_Date".equals(talendType) || "java.util.Date".equals(javaClass)) {
            return value instanceof Date ? value : new Date((Long) value);
        } else if ("id_Byte".equals(talendType)) {
            return value instanceof Number ? ((Number) value).byteValue() : Byte.parseByte(String.valueOf(value));
        } else if ("id_Character".equals(talendType) || "java.lang.Character".equals(javaClass)) {
            return value instanceof Character ? value : ((String) value).charAt(0);
        } else if ("id_BigDecimal".equals(talendType) || "java.math.BigDecimal".equals(javaClass)) {
            return value instanceof BigDecimal ? value : new BigDecimal(String.valueOf(value));
        }
        return value;
    }

    /**
     * Creates {@link Schema} of dynamic fields
     * Note, this method is used only in constructor
     * 
     * @param indexMapper instance of {@link DynamicIndexMapper}, it provides dynamic field indexes
     */
    private void createDynamicFieldsSchema(DynamicIndexMapper indexMapper) {
        List<Field> dynamicFields = new ArrayList<>();
        List<Integer> dynamicFieldsIndexes = indexMapper.computeDynamicFieldsIndexes();
        for (int index : dynamicFieldsIndexes) {
            Field dynamicField = runtimeFields.get(index);
            Field dynamicFieldCopy = new Schema.Field(dynamicField.name(), dynamicField.schema(), dynamicField.doc(),
                    dynamicField.defaultVal());
            Map<String, Object> fieldProperties = dynamicField.getObjectProps();
            for (Map.Entry<String, Object> entry : fieldProperties.entrySet()) {
                Object propValue = entry.getValue();
                if (propValue != null) {
                    dynamicFieldCopy.addProp(entry.getKey(), propValue);
                }
            }
            dynamicFields.add(dynamicFieldCopy);
        }

        dynamicFieldsSchema = Schema.createRecord("dynamic", null, null, false);
        dynamicFieldsSchema.setFields(dynamicFields);
    }
}