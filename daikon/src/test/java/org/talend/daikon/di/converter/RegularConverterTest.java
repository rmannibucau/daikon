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

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.talend.daikon.avro.converter.AvroConverter;

/**
 * Unit-tests for {@link RegularConverter}
 */
public class RegularConverterTest {

    /**
     * Checks {@link RegularConverter#getSchema()} throws {@link UnsupportedOperationException}
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testGetSchema() {
        AvroConverter<?, ?> converter = RegularConverter.getInstance();
        converter.getSchema();
    }

    /**
     * Checks {@link RegularConverter#getDatumClass()} throws {@link UnsupportedOperationException}
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testGetDatumClass() {
        AvroConverter<?, ?> converter = RegularConverter.getInstance();
        converter.getDatumClass();
    }

    /**
     * Checks {@link RegularConverter#convertToAvro()} returns array ({@link List}) value without any changes
     */
    @Test
    public void testConvertToAvroArray() {
        List<String> expected = Arrays.asList("one", "two", "three");

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        @SuppressWarnings("unchecked")
        List<String> actual = (List<String>) converter.convertToAvro(expected);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Checks {@link RegularConverter#convertToAvro()} returns boolean value without any changes
     */
    @Test
    public void testConvertToAvroBoolean() {
        boolean expected = true;

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        boolean actual = (Boolean) converter.convertToAvro(expected);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Checks {@link RegularConverter#convertToAvro()} returns byte[] value without any changes
     */
    @Test
    public void testConvertToAvroBytes() {
        byte[] expected = new byte[] { 0, 1, 2, 3 };

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        byte[] actual = (byte[]) converter.convertToAvro(expected);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Checks {@link RegularConverter#convertToAvro()} returns int value without any changes
     */
    @Test
    public void testConvertToAvroInt() {
        int expected = 12345;

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        int actual = (Integer) converter.convertToAvro(expected);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Checks {@link RegularConverter#convertToAvro()} returns long value without any changes
     */
    @Test
    public void testConvertToAvroLong() {
        long expected = 123456789l;

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        long actual = (Long) converter.convertToAvro(expected);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Checks {@link RegularConverter#convertToAvro()} returns float value without any changes
     */
    @Test
    public void testConvertToAvroFloat() {
        float expected = 12.34f;

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        float actual = (Float) converter.convertToAvro(expected);
        Assert.assertEquals(expected, actual, 0f);
    }

    /**
     * Checks {@link RegularConverter#convertToAvro()} returns double value without any changes
     */
    @Test
    public void testConvertToAvroDouble() {
        double expected = 12.34;

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        double actual = (Double) converter.convertToAvro(expected);
        Assert.assertEquals(expected, actual, 0);
    }

    /**
     * Checks {@link RegularConverter#convertToAvro()} returns string value without any changes
     */
    @Test
    public void testConvertToAvroString() {
        String expected = "abcd";

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        String actual = (String) converter.convertToAvro(expected);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Checks {@link RegularConverter#convertToDatum()} returns array({@link List}) value without any changes
     */
    @Test
    public void testConvertToDatumArray() {
        List<Integer> expected = Arrays.asList(4, 5, 6);

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        @SuppressWarnings("unchecked")
        List<Integer> actual = (List<Integer>) converter.convertToDatum(expected);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Checks {@link RegularConverter#convertToDatum()} returns boolean value without any changes
     */
    @Test
    public void testConvertToDatumBoolean() {
        boolean expected = false;

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        boolean actual = (Boolean) converter.convertToDatum(expected);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Checks {@link RegularConverter#convertToDatum()} returns byte[] value without any changes
     */
    @Test
    public void testConvertToDatumBytes() {
        byte[] expected = new byte[] { 0, 1, 2, 3 };

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        byte[] actual = (byte[]) converter.convertToDatum(expected);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Checks {@link RegularConverter#convertToDatum()} returns int value without any changes
     */
    @Test
    public void testConvertToDatumInt() {
        int expected = 12345;

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        int actual = (Integer) converter.convertToDatum(expected);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Checks {@link RegularConverter#convertToDatum()} returns long value without any changes
     */
    @Test
    public void testConvertToDatumLong() {
        long expected = 123456789l;

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        long actual = (Long) converter.convertToDatum(expected);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Checks {@link RegularConverter#convertToDatum()} returns float value without any changes
     */
    @Test
    public void testConvertToDatumFloat() {
        float expected = 1234.5678f;

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        float actual = (Float) converter.convertToDatum(expected);
        Assert.assertEquals(expected, actual, 0f);
    }

    /**
     * Checks {@link RegularConverter#convertToDatum()} returns double value without any changes
     */
    @Test
    public void testConvertToDatumDouble() {
        double expected = 1234.5678;

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        double actual = (Double) converter.convertToDatum(expected);
        Assert.assertEquals(expected, actual, 0);
    }

    /**
     * Checks {@link RegularConverter#convertToDatum()} returns String value without any changes
     */
    @Test
    public void testConvertToDatumString() {
        String expected = "abcd";

        AvroConverter<Object, Object> converter = RegularConverter.getInstance();
        String actual = (String) converter.convertToDatum(expected);
        Assert.assertEquals(expected, actual);
    }
}
