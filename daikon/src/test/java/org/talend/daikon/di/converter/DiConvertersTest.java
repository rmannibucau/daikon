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
package org.talend.daikon.di.converter;

import java.util.Date;
import java.util.List;

import org.apache.avro.Schema;
import org.apache.avro.SchemaBuilder;
import org.junit.Test;
import org.talend.daikon.avro.AvroUtils;
import org.talend.daikon.avro.converter.AvroConverter;

/**
 * Unit-tests for {@link DiConverters}
 */
public class DiConvertersTest {

    /**
     * Draft test to test ClassCastException
     */
    @Test
    public void testInitConverters() {
        Schema schema = SchemaBuilder.record("records").fields() //
                .name("logicalDate").type(AvroUtils._logicalDate()).noDefault() //
                .endRecord(); //
        
        List<AvroConverter> converters = DiConverters.initConverters(schema);
        AvroConverter converter = converters.get(0);
        Integer result = (Integer) converter.convertToAvro(17l);
        System.out.println(result);
    }
}
