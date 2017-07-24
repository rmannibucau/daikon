// ============================================================================
//
// Copyright (C) 2006-2017 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.daikon.properties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.talend.daikon.properties.presentation.Form;

/**
 * Class representing a list of Properties, which can be represented as a row-based table. Every Properties object in
 * the list represents a separate row in the table. Every Row of the table can have it's own validation rules and it's
 * own methods to update Property fields, which it contains. Thus it should be possible to set a different set of
 * possible values for each "Cell" in the table(Property field in the Properties object).
 */
public class PropertiesList<T extends Properties> extends PropertiesImpl {

    public final static String ROW_NAME_PREFIX = "row";

    /**
     * List of all properties present in the table
     */
    public List<T> subProperties = new ArrayList<>();

    /**
     * required for table row schema.
     */
    public transient T defaultProperties;

    private final transient NestedPropertiesFactory<T> factory;

    public PropertiesList(String name, NestedPropertiesFactory<T> factory) {
        super(name);
        this.factory = factory;
        this.defaultProperties = factory.create("defaultProperties");
    }

    @Override
    public void setupLayout() {
        super.setupLayout();

        Form main = new Form(this, Form.MAIN);
        layoutPropertiesOnForm(main);
    }

    /**
     * Put all the rows to the given form
     */
    protected void layoutPropertiesOnForm(Form form) {
        for (Properties props : subProperties) {
            props.init();
            form.addRow(props.getForm(Form.MAIN));
        }
    }

    @Override
    public void refreshLayout(Form form) {
        super.refreshLayout(form);
        if (Form.MAIN.equals(form.getName())) {
            form.clearForm();
            layoutPropertiesOnForm(form);
        }
    }

    /**
     * Get list of properties defined for this object.
     */
    public Collection<T> getPropertiesList() {
        return subProperties;
    }

    /**
     * Add one data row.
     */
    public void addRow(T props) {
        subProperties.add(props);
        props.init();
        getForm(Form.MAIN).addRow(props.getForm(Form.MAIN));
    }

    /**
     * This method will create a row using {@link NestedPropertiesFactory} with a default name created of
     * {@link PropertiesList#ROW_NAME_PREFIX} and position in the properties list the new properties are added at. </br>
     * Example: </br>
     * If there are already 2 rows existing and we add the 3rd one, the name would be combined of
     * {@link PropertiesList#ROW_NAME_PREFIX} and number 3. The result will be {@code "row3"} </br>
     * 
     * @return object created using factory and added to the list of properties.
     */
    public T createAndAddRow() {
        T newRow = this.factory.create("row" + (subProperties.size() + 1));
        this.addRow(newRow);
        return newRow;
    }

    /**
     * Set table data.
     */
    public void setRows(Collection<T> subProps) {
        subProperties.clear();
        subProperties.addAll(subProps);
        refreshLayout(getForm(Form.MAIN));
    }

    /**
     * Add collection of properties to current list
     */
    public void addAllRows(Collection<T> props) {
        subProperties.addAll(props);
        refreshLayout(getForm(Form.MAIN));
    }

    /**
     * get default properties for this properties list.
     */
    public T getDefaultProperties() {
        return defaultProperties;
    }

    /**
     * Create a new properties instance for this properties list.
     */
    public T createNestedProperties(String name) {
        return this.factory.create(name);
    }

    /**
     * Factory to create a nested properties object, to be added to the list of PropertiesList object.
     */
    public static interface NestedPropertiesFactory<T extends Properties> {

        /**
         * Create and return object with given name
         */
        public T create(String name);

    }

}
