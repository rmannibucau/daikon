package org.talend.daikon.container;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class TypeConverterTest {

    String input_String = "3"; //$NON-NLS-1$

    String input_String_double = "3.0"; //$NON-NLS-1$

    String input_String_empty = ""; //$NON-NLS-1$

    String input_String_default = "0"; //$NON-NLS-1$

    String input_String_default_double = "0.0"; //$NON-NLS-1$

    String input_String_default_char = "a"; //$NON-NLS-1$

    String input_String_default_boolean = "true"; //$NON-NLS-1$

    String input_String_default_boolean_number = "1"; //$NON-NLS-1$

    String input_String_null = null;

    java.nio.ByteBuffer input_ByteBuffer_null = null;

    byte input_byte = 3;

    byte input_byte_default = 0;

    Byte input_Byte = 3;

    Byte input_Byte_null = null;

    Byte input_Byte_default = 0;

    boolean input_boolean = true;

    boolean input_boolean_default = false;

    Boolean input_Boolean = true;

    Boolean input_Boolean_default = false;

    Boolean input_Boolean_null = null;

    double input_double = 3.0d;

    double input_double_default = 0d;

    Double input_Double = 3.0D;

    Double input_Double_null = null;

    Double input_Double_default = 0D;

    float input_float = 3.0f;

    float input_float_default = 0f;

    Float input_Float = 3.0F;

    Float input_Float_null = null;

    Float input_Float_default = 0F;

    BigDecimal input_BigDecimal = new BigDecimal(3);

    // weird error case
    BigDecimal input_BigDecimal_double = new BigDecimal(((Double) 3.000D).toString());

    BigDecimal input_BigDecimal_null = null;

    BigDecimal input_BigDecimal_default = new BigDecimal(0);

    BigDecimal input_BigDecimal_defaultdouble = BigDecimal.valueOf(0.0d);

    int input_int = 3;

    int input_int_default = 0;

    Integer input_Integer = 3;

    Integer input_Integer_null = null;

    Integer input_Integer_default = 0;

    long input_long = 3l;

    long input_long_default = 0l;

    Long input_Long = 3L;

    Long input_Long_null = null;

    Long input_Long_default = 0L;

    short input_short = 3;

    short input_short_default = 0;

    Short input_Short = 3;

    Short input_Short_null = null;

    Short input_Short_default = 0;

    char input_char = 'a';

    char input_char_default = ' ';

    Character input_Char = 'a';

    Character input_Char_null = null;

    Character input_Char_default = ' ';

    String object_test = "a"; //$NON-NLS-1$

    @Test
    public void test_asString() {
        assertEquals(input_String, TypeConverter.asString().convert(input_String));
        assertEquals(input_String, TypeConverter.asString().convert(input_byte));
        assertEquals(input_String, TypeConverter.asString().convert(input_Byte));
        assertEquals(input_String, TypeConverter.asString().convert(java.nio.ByteBuffer.wrap(input_String.getBytes())));
        assertEquals(input_String_double, TypeConverter.asString().convert(input_double));
        assertEquals(input_String_double, TypeConverter.asString().convert(input_Double));
        assertEquals(input_String_double, TypeConverter.asString().convert(input_float));
        assertEquals(input_String_double, TypeConverter.asString().convert(input_Float));
        assertEquals(input_String, TypeConverter.asString().convert(input_BigDecimal));
        assertEquals(input_String, TypeConverter.asString().convert(input_int));
        assertEquals(input_String, TypeConverter.asString().convert(input_Integer));
        assertEquals(input_String, TypeConverter.asString().convert(input_long));
        assertEquals(input_String, TypeConverter.asString().convert(input_Long));
        assertEquals(input_String, TypeConverter.asString().convert(input_short));
        assertEquals(input_String, TypeConverter.asString().convert(input_Short));
        assertEquals(input_String_default_char, TypeConverter.asString().convert(input_char));
        assertEquals(input_String_default_char, TypeConverter.asString().convert(input_Char));
    }

    @Test
    public void test_asString_default() {
        assertEquals(input_String_null, TypeConverter.asString().convert(input_String_null));
        assertEquals(input_String_null, TypeConverter.asString().convert(input_ByteBuffer_null));
        assertEquals(input_String_default, TypeConverter.asString().convert(input_byte_default));
        assertEquals(input_String_null, TypeConverter.asString().convert(input_Byte_null));
        assertEquals(input_String_default_double, TypeConverter.asString().convert(input_double_default));
        assertEquals(input_String_null, TypeConverter.asString().convert(input_Double_null));
        assertEquals(input_String_default_double, TypeConverter.asString().convert(input_float_default));
        assertEquals(input_String_null, TypeConverter.asString().convert(input_Float_null));
        assertEquals(input_String_null, TypeConverter.asString().convert(input_BigDecimal_null));
        assertEquals(input_String_default, TypeConverter.asString().convert(input_int_default));
        assertEquals(input_String_null, TypeConverter.asString().convert(input_Integer_null));
        assertEquals(input_String_default, TypeConverter.asString().convert(input_long_default));
        assertEquals(input_String_null, TypeConverter.asString().convert(input_Long_null));
        assertEquals(input_String_default, TypeConverter.asString().convert(input_short_default));
        assertEquals(input_String_null, TypeConverter.asString().convert(input_Short_null));
    }

    @Test
    public void test_asString_default_withValue() {
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_String_null));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_ByteBuffer_null));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_byte_default));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_Byte_null));
        assertEquals(input_String_default_double,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_double_default));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_Double_null));
        assertEquals(input_String_default_double,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_float_default));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_Float_null));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_BigDecimal_null));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_int_default));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_Integer_null));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_long_default));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_Long_null));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_short_default));
        assertEquals(input_String_default,
                TypeConverter.asString().withDefaultValue(input_String_default).convert(input_Short_null));
    }

    @Test
    public void test_asInteger() {
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_String));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_byte));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_Byte));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_double));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_Double));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_float));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_Float));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_BigDecimal));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_int));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_Integer));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_long));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_Long));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_short));
        assertEquals(input_Integer, TypeConverter.asInteger().convert(input_Short));
    }

    @Test
    public void test_asInteger_default() {
        assertEquals(input_Integer_null, TypeConverter.asInteger().convert(input_String_null));
        assertEquals(input_Integer_default, TypeConverter.asInteger().convert(input_byte_default));
        assertEquals(input_Integer_null, TypeConverter.asInteger().convert(input_Byte_null));
        assertEquals(input_Integer_default, TypeConverter.asInteger().convert(input_double_default));
        assertEquals(input_Integer_null, TypeConverter.asInteger().convert(input_Double_null));
        assertEquals(input_Integer_default, TypeConverter.asInteger().convert(input_float_default));
        assertEquals(input_Integer_null, TypeConverter.asInteger().convert(input_Float_null));
        assertEquals(input_Integer_null, TypeConverter.asInteger().convert(input_BigDecimal_null));
        assertEquals(input_Integer_default, TypeConverter.asInteger().convert(input_int_default));
        assertEquals(input_Integer_null, TypeConverter.asInteger().convert(input_Integer_null));
        assertEquals(input_Integer_default, TypeConverter.asInteger().convert(input_long_default));
        assertEquals(input_Integer_null, TypeConverter.asInteger().convert(input_Long_null));
        assertEquals(input_Integer_default, TypeConverter.asInteger().convert(input_short_default));
        assertEquals(input_Integer_null, TypeConverter.asInteger().convert(input_Short_null));
    }

    @Test
    public void test_asInteger_default_withValue() {
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_String_null));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_byte_default));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_Byte_null));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_double_default));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_Double_null));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_float_default));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_Float_null));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_BigDecimal_null));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_int_default));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_Integer_null));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_long_default));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_Long_null));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_short_default));
        assertEquals(input_Integer_default,
                TypeConverter.asInteger().withDefaultValue(input_Integer_default).convert(input_Short_null));
    }

    @Test
    public void test_asByte() {
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_String));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_byte));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_Byte));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_double));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_Double));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_float));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_Float));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_BigDecimal));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_int));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_Integer));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_long));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_Long));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_short));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_Short));
        assertEquals(input_Byte, TypeConverter.asByte().convert(input_Short));
        assertEquals(Byte.valueOf((byte) 0), TypeConverter.asByte().convert(false));
        assertEquals(Byte.valueOf((byte) 1), TypeConverter.asByte().convert(true));
    }

    @Test
    public void test_asByte_default() {
        assertEquals(input_Byte_null, TypeConverter.asByte().convert(input_String_null));
        assertEquals(input_Byte_default, TypeConverter.asByte().convert(input_byte_default));
        assertEquals(input_Byte_null, TypeConverter.asByte().convert(input_Byte_null));
        assertEquals(input_Byte_default, TypeConverter.asByte().convert(input_double_default));
        assertEquals(input_Byte_null, TypeConverter.asByte().convert(input_Double_null));
        assertEquals(input_Byte_default, TypeConverter.asByte().convert(input_float_default));
        assertEquals(input_Byte_null, TypeConverter.asByte().convert(input_Float_null));
        assertEquals(input_Byte_null, TypeConverter.asByte().convert(input_BigDecimal_null));
        assertEquals(input_Byte_default, TypeConverter.asByte().convert(input_int_default));
        assertEquals(input_Byte_null, TypeConverter.asByte().convert(input_Integer_null));
        assertEquals(input_Byte_default, TypeConverter.asByte().convert(input_long_default));
        assertEquals(input_Byte_null, TypeConverter.asByte().convert(input_Long_null));
        assertEquals(input_Byte_default, TypeConverter.asByte().convert(input_short_default));
        assertEquals(input_Byte_null, TypeConverter.asByte().convert(input_Short_null));
        assertEquals(input_Byte_default, TypeConverter.asByte().convert(input_boolean_default));
        assertEquals(input_Byte_null, TypeConverter.asByte().convert(input_Boolean_null));
    }

    @Test
    public void test_asByte_default_withValue() {
        assertEquals(input_Byte_default, TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_String_null));
        assertEquals(input_Byte_default, TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_byte_default));
        assertEquals(input_Byte_default, TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_Byte_null));
        assertEquals(input_Byte_default,
                TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_double_default));
        assertEquals(input_Byte_default, TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_Double_null));
        assertEquals(input_Byte_default,
                TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_float_default));
        assertEquals(input_Byte_default, TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_Float_null));
        assertEquals(input_Byte_default,
                TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_BigDecimal_null));
        assertEquals(input_Byte_default, TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_int_default));
        assertEquals(input_Byte_default, TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_Integer_null));
        assertEquals(input_Byte_default, TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_long_default));
        assertEquals(input_Byte_default, TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_Long_null));
        assertEquals(input_Byte_default,
                TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_short_default));
        assertEquals(input_Byte_default, TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_Short_null));
        assertEquals(input_Byte_default,
                TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_boolean_default));
        assertEquals(input_Byte_default, TypeConverter.asByte().withDefaultValue(input_Byte_default).convert(input_Boolean_null));
    }

    @Test
    public void test_asDouble() {
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_String));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_byte));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_Byte));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_double));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_Double));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_float));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_Float));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_BigDecimal));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_int));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_Integer));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_long));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_Long));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_short));
        assertEquals(input_Double, TypeConverter.asDouble().convert(input_Short));
    }

    @Test
    public void test_asDouble_default() {
        assertEquals(input_Double_null, TypeConverter.asDouble().convert(input_String_null));
        assertEquals(input_Double_default, TypeConverter.asDouble().convert(input_byte_default));
        assertEquals(input_Double_null, TypeConverter.asDouble().convert(input_Byte_null));
        assertEquals(input_Double_default, TypeConverter.asDouble().convert(input_double_default));
        assertEquals(input_Double_null, TypeConverter.asDouble().convert(input_Double_null));
        assertEquals(input_Double_default, TypeConverter.asDouble().convert(input_float_default));
        assertEquals(input_Double_null, TypeConverter.asDouble().convert(input_Float_null));
        assertEquals(input_Double_null, TypeConverter.asDouble().convert(input_BigDecimal_null));
        assertEquals(input_Double_default, TypeConverter.asDouble().convert(input_int_default));
        assertEquals(input_Double_null, TypeConverter.asDouble().convert(input_Integer_null));
        assertEquals(input_Double_default, TypeConverter.asDouble().convert(input_long_default));
        assertEquals(input_Double_null, TypeConverter.asDouble().convert(input_Long_null));
        assertEquals(input_Double_default, TypeConverter.asDouble().convert(input_short_default));
        assertEquals(input_Double_null, TypeConverter.asDouble().convert(input_Short_null));
    }

    @Test
    public void test_asDouble_default_withValue() {
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_String_null));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_byte_default));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_Byte_null));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_double_default));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_Double_null));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_float_default));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_Float_null));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_BigDecimal_null));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_int_default));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_Integer_null));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_long_default));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_Long_null));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_short_default));
        assertEquals(input_Double_default,
                TypeConverter.asDouble().withDefaultValue(input_Double_default).convert(input_Short_null));
    }

    @Test
    public void test_asFloat() {
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_String));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_byte));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_Byte));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_double));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_Double));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_float));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_Float));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_BigDecimal));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_int));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_Integer));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_long));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_Long));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_short));
        assertEquals(input_Float, TypeConverter.asFloat().convert(input_Short));
    }

    @Test
    public void test_asFloat_default() {
        assertEquals(input_Float_null, TypeConverter.asFloat().convert(input_String_null));
        assertEquals(input_Float_default, TypeConverter.asFloat().convert(input_byte_default));
        assertEquals(input_Float_null, TypeConverter.asFloat().convert(input_Byte_null));
        assertEquals(input_Float_default, TypeConverter.asFloat().convert(input_double_default));
        assertEquals(input_Float_null, TypeConverter.asFloat().convert(input_Double_null));
        assertEquals(input_Float_default, TypeConverter.asFloat().convert(input_float_default));
        assertEquals(input_Float_null, TypeConverter.asFloat().convert(input_Float_null));
        assertEquals(input_Float_null, TypeConverter.asFloat().convert(input_BigDecimal_null));
        assertEquals(input_Float_default, TypeConverter.asFloat().convert(input_int_default));
        assertEquals(input_Float_null, TypeConverter.asFloat().convert(input_Integer_null));
        assertEquals(input_Float_default, TypeConverter.asFloat().convert(input_long_default));
        assertEquals(input_Float_null, TypeConverter.asFloat().convert(input_Long_null));
        assertEquals(input_Float_default, TypeConverter.asFloat().convert(input_short_default));
        assertEquals(input_Float_null, TypeConverter.asFloat().convert(input_Short_null));
    }

    @Test
    public void test_asFloat_default_withValue() {
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_String_null));
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_byte_default));
        assertEquals(input_Float_default, TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_Byte_null));
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_double_default));
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_Double_null));
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_float_default));
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_Float_null));
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_BigDecimal_null));
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_int_default));
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_Integer_null));
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_long_default));
        assertEquals(input_Float_default, TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_Long_null));
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_short_default));
        assertEquals(input_Float_default,
                TypeConverter.asFloat().withDefaultValue(input_Float_default).convert(input_Short_null));
    }

    @Test
    public void test_asBigDecimal() {
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_String));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_byte));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_Byte));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_double));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_Double));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_float));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_Float));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_BigDecimal));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_int));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_Integer));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_long));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_Long));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_short));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().convert(input_Short));
    }

    @Test
    public void test_asBigDecimal_default() {
        assertEquals(input_BigDecimal_null, TypeConverter.asBigDecimal().convert(input_String_null));
        assertEquals(input_BigDecimal_default, TypeConverter.asBigDecimal().convert(input_byte_default));
        assertEquals(input_BigDecimal_null, TypeConverter.asBigDecimal().convert(input_Byte_null));
        assertEquals(input_BigDecimal_default, TypeConverter.asBigDecimal().convert(input_double_default));
        assertEquals(input_BigDecimal_null, TypeConverter.asBigDecimal().convert(input_Double_null));
        assertEquals(input_BigDecimal_default, TypeConverter.asBigDecimal().convert(input_float_default));
        assertEquals(input_BigDecimal_null, TypeConverter.asBigDecimal().convert(input_Float_null));
        assertEquals(input_BigDecimal_null, TypeConverter.asBigDecimal().convert(input_BigDecimal_null));
        assertEquals(input_BigDecimal_default, TypeConverter.asBigDecimal().convert(input_int_default));
        assertEquals(input_BigDecimal_null, TypeConverter.asBigDecimal().convert(input_Integer_null));
        assertEquals(input_BigDecimal_default, TypeConverter.asBigDecimal().convert(input_long_default));
        assertEquals(input_BigDecimal_null, TypeConverter.asBigDecimal().convert(input_Long_null));
        assertEquals(input_BigDecimal_default, TypeConverter.asBigDecimal().convert(input_short_default));
        assertEquals(input_BigDecimal_null, TypeConverter.asBigDecimal().convert(input_Short_null));
    }

    @Test
    public void test_asBigDecimal_default_withValue() {
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_String_null));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_byte_default));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_Byte_null));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_double_default));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_Double_null));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_float_default));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_Float_null));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_BigDecimal_null));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_int_default));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_Integer_null));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_long_default));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_Long_null));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_short_default));
        assertEquals(input_BigDecimal_default,
                TypeConverter.asBigDecimal().withDefaultValue(input_BigDecimal_default).convert(input_Short_null));
    }

    @Test
    public void test_asLong() {
        assertEquals(input_Long, TypeConverter.asLong().convert(input_String));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_byte));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_Byte));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_double));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_Double));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_float));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_Float));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_BigDecimal));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_int));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_Integer));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_long));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_Long));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_short));
        assertEquals(input_Long, TypeConverter.asLong().convert(input_Short));
    }

    @Test
    public void test_asLong_default() {
        assertEquals(input_Long_null, TypeConverter.asLong().convert(input_String_null));
        assertEquals(input_Long_default, TypeConverter.asLong().convert(input_byte_default));
        assertEquals(input_Long_null, TypeConverter.asLong().convert(input_Byte_null));
        assertEquals(input_Long_default, TypeConverter.asLong().convert(input_double_default));
        assertEquals(input_Long_null, TypeConverter.asLong().convert(input_Double_null));
        assertEquals(input_Long_default, TypeConverter.asLong().convert(input_float_default));
        assertEquals(input_Long_null, TypeConverter.asLong().convert(input_Float_null));
        assertEquals(input_Long_null, TypeConverter.asLong().convert(input_BigDecimal_null));
        assertEquals(input_Long_default, TypeConverter.asLong().convert(input_int_default));
        assertEquals(input_Long_null, TypeConverter.asLong().convert(input_Integer_null));
        assertEquals(input_Long_default, TypeConverter.asLong().convert(input_long_default));
        assertEquals(input_Long_null, TypeConverter.asLong().convert(input_Long_null));
        assertEquals(input_Long_default, TypeConverter.asLong().convert(input_short_default));
        assertEquals(input_Long_null, TypeConverter.asLong().convert(input_Short_null));
    }

    @Test
    public void test_asLong_default_withValue() {
        assertEquals(input_Long_default, TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_String_null));
        assertEquals(input_Long_default, TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_byte_default));
        assertEquals(input_Long_default, TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_Byte_null));
        assertEquals(input_Long_default,
                TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_double_default));
        assertEquals(input_Long_default, TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_Double_null));
        assertEquals(input_Long_default,
                TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_float_default));
        assertEquals(input_Long_default, TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_Float_null));
        assertEquals(input_Long_default,
                TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_BigDecimal_null));
        assertEquals(input_Long_default, TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_int_default));
        assertEquals(input_Long_default, TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_Integer_null));
        assertEquals(input_Long_default, TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_long_default));
        assertEquals(input_Long_default, TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_Long_null));
        assertEquals(input_Long_default,
                TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_short_default));
        assertEquals(input_Long_default, TypeConverter.asLong().withDefaultValue(input_Long_default).convert(input_Short_null));
    }

    @Test
    public void test_asShort() {
        assertEquals(input_Short, TypeConverter.asShort().convert(input_String));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_byte));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_Byte));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_double));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_Double));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_float));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_Float));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_BigDecimal));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_int));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_Integer));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_long));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_Long));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_short));
        assertEquals(input_Short, TypeConverter.asShort().convert(input_Short));
    }

    @Test
    public void test_asShort_default() {
        assertEquals(input_Short_null, TypeConverter.asShort().convert(input_String_null));
        assertEquals(input_Short_default, TypeConverter.asShort().convert(input_byte_default));
        assertEquals(input_Short_null, TypeConverter.asShort().convert(input_Byte_null));
        assertEquals(input_Short_default, TypeConverter.asShort().convert(input_double_default));
        assertEquals(input_Short_null, TypeConverter.asShort().convert(input_Double_null));
        assertEquals(input_Short_default, TypeConverter.asShort().convert(input_float_default));
        assertEquals(input_Short_null, TypeConverter.asShort().convert(input_Float_null));
        assertEquals(input_Short_null, TypeConverter.asShort().convert(input_BigDecimal_null));
        assertEquals(input_Short_default, TypeConverter.asShort().convert(input_int_default));
        assertEquals(input_Short_null, TypeConverter.asShort().convert(input_Integer_null));
        assertEquals(input_Short_default, TypeConverter.asShort().convert(input_long_default));
        assertEquals(input_Short_null, TypeConverter.asShort().convert(input_Long_null));
        assertEquals(input_Short_default, TypeConverter.asShort().convert(input_short_default));
        assertEquals(input_Short_null, TypeConverter.asShort().convert(input_Short_null));
    }

    @Test
    public void test_asShort_default_withValue() {
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_String_null));
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_byte_default));
        assertEquals(input_Short_default, TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_Byte_null));
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_double_default));
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_Double_null));
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_float_default));
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_Float_null));
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_BigDecimal_null));
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_int_default));
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_Integer_null));
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_long_default));
        assertEquals(input_Short_default, TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_Long_null));
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_short_default));
        assertEquals(input_Short_default,
                TypeConverter.asShort().withDefaultValue(input_Short_default).convert(input_Short_null));
    }

    @Test
    public void test_asCharacter() {
        assertEquals((Character) input_String.charAt(0), TypeConverter.asCharacter().convert(input_String));
        assertEquals(input_Char, TypeConverter.asCharacter().convert(input_char));
        assertEquals(input_Char, TypeConverter.asCharacter().convert(input_Char));
    }

    @Test
    public void test_asCharacter_default() {
        assertEquals(input_Char_null, TypeConverter.asCharacter().convert(input_String_null));
        assertEquals(input_Char_default, TypeConverter.asCharacter().convert(input_char_default));
        assertEquals(input_Char_null, TypeConverter.asCharacter().convert(input_Char_null));
    }

    @Test
    public void test_asCharacter_default_withValue() {
        assertEquals(input_Char_default,
                TypeConverter.asCharacter().withDefaultValue(input_Char_default).convert(input_String_null));
        assertEquals(input_Char_default,
                TypeConverter.asCharacter().withDefaultValue(input_Char_default).convert(input_char_default));
        assertEquals(input_Char_default,
                TypeConverter.asCharacter().withDefaultValue(input_Char_default).convert(input_Char_null));
    }

    @Test
    public void test_asBoolean() {
        assertEquals(input_boolean, TypeConverter.asBoolean().convert(input_boolean));
        assertEquals(input_Boolean, TypeConverter.asBoolean().convert(input_Boolean));
        assertEquals(input_Boolean_default, TypeConverter.asBoolean().convert(input_Boolean_default));
        assertEquals(input_Boolean_null, TypeConverter.asBoolean().convert(input_Boolean_null));

        assertEquals(input_Boolean_default, TypeConverter.asBoolean().convert(input_String));
        assertEquals(input_Boolean, TypeConverter.asBoolean().convert(input_String_default_boolean));
        assertEquals(input_Boolean, TypeConverter.asBoolean().convert(input_String_default_boolean_number));
        assertEquals(input_Boolean_null, TypeConverter.asBoolean().convert(input_String_null));
        assertEquals(input_Boolean_null, TypeConverter.asBoolean().convert(""));
    }

    @Test
    public void test_asBoolean_default_withValue() {
        assertEquals(false, TypeConverter.asBoolean().withDefaultValue(false).convert(input_Boolean_null));

        assertEquals(false, TypeConverter.asBoolean().withDefaultValue(false).convert(input_String_null));
        assertEquals(false, TypeConverter.asBoolean().withDefaultValue(false).convert(""));
    }

    @Test
    public void test_as_String() {
        assertEquals(input_String, TypeConverter.as(String.class).convert(input_String));
        assertEquals(input_String, TypeConverter.as(String.class).convert(input_byte));
        assertEquals(input_String, TypeConverter.as(String.class).convert(input_Byte));
        assertEquals(input_String, TypeConverter.as(String.class).convert(java.nio.ByteBuffer.wrap(input_String.getBytes())));
        assertEquals(input_String_double, TypeConverter.as(String.class).convert(input_double));
        assertEquals(input_String_double, TypeConverter.as(String.class).convert(input_Double));
        assertEquals(input_String_double, TypeConverter.as(String.class).convert(input_float));
        assertEquals(input_String_double, TypeConverter.as(String.class).convert(input_Float));
        assertEquals(input_String, TypeConverter.as(String.class).convert(input_BigDecimal));
        assertEquals(input_String, TypeConverter.as(String.class).convert(input_int));
        assertEquals(input_String, TypeConverter.as(String.class).convert(input_Integer));
        assertEquals(input_String, TypeConverter.as(String.class).convert(input_long));
        assertEquals(input_String, TypeConverter.as(String.class).convert(input_Long));
        assertEquals(input_String, TypeConverter.as(String.class).convert(input_short));
        assertEquals(input_String, TypeConverter.as(String.class).convert(input_Short));
        assertEquals(input_String_default_char, TypeConverter.as(String.class).convert(input_char));
        assertEquals(input_String_default_char, TypeConverter.as(String.class).convert(input_Char));
    }

    @Test
    public void test_as_String_default() {
        assertEquals(input_String_null, TypeConverter.as(String.class).convert(input_String_null));
        assertEquals(input_String_null, TypeConverter.as(String.class).convert(input_ByteBuffer_null));
        assertEquals(input_String_default, TypeConverter.as(String.class).convert(input_byte_default));
        assertEquals(input_String_null, TypeConverter.as(String.class).convert(input_Byte_null));
        assertEquals(input_String_default_double, TypeConverter.as(String.class).convert(input_double_default));
        assertEquals(input_String_null, TypeConverter.as(String.class).convert(input_Double_null));
        assertEquals(input_String_default_double, TypeConverter.as(String.class).convert(input_float_default));
        assertEquals(input_String_null, TypeConverter.as(String.class).convert(input_Float_null));
        assertEquals(input_String_null, TypeConverter.as(String.class).convert(input_BigDecimal_null));
        assertEquals(input_String_default, TypeConverter.as(String.class).convert(input_int_default));
        assertEquals(input_String_null, TypeConverter.as(String.class).convert(input_Integer_null));
        assertEquals(input_String_default, TypeConverter.as(String.class).convert(input_long_default));
        assertEquals(input_String_null, TypeConverter.as(String.class).convert(input_Long_null));
        assertEquals(input_String_default, TypeConverter.as(String.class).convert(input_short_default));
        assertEquals(input_String_null, TypeConverter.as(String.class).convert(input_Short_null));
    }

    @Test
    public void test_as_Integer() {
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_String));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_byte));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_Byte));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_double));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_Double));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_float));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_Float));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_BigDecimal));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_int));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_Integer));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_long));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_Long));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_short));
        assertEquals(input_Integer, TypeConverter.as(Integer.class).convert(input_Short));
    }

    @Test
    public void test_as_Integer_default() {
        assertEquals(input_Integer_null, TypeConverter.as(Integer.class).convert(input_String_null));
        assertEquals(input_Integer_default, TypeConverter.as(Integer.class).convert(input_byte_default));
        assertEquals(input_Integer_null, TypeConverter.as(Integer.class).convert(input_Byte_null));
        assertEquals(input_Integer_default, TypeConverter.as(Integer.class).convert(input_double_default));
        assertEquals(input_Integer_null, TypeConverter.as(Integer.class).convert(input_Double_null));
        assertEquals(input_Integer_default, TypeConverter.as(Integer.class).convert(input_float_default));
        assertEquals(input_Integer_null, TypeConverter.as(Integer.class).convert(input_Float_null));
        assertEquals(input_Integer_null, TypeConverter.as(Integer.class).convert(input_BigDecimal_null));
        assertEquals(input_Integer_default, TypeConverter.as(Integer.class).convert(input_int_default));
        assertEquals(input_Integer_null, TypeConverter.as(Integer.class).convert(input_Integer_null));
        assertEquals(input_Integer_default, TypeConverter.as(Integer.class).convert(input_long_default));
        assertEquals(input_Integer_null, TypeConverter.as(Integer.class).convert(input_Long_null));
        assertEquals(input_Integer_default, TypeConverter.as(Integer.class).convert(input_short_default));
        assertEquals(input_Integer_null, TypeConverter.as(Integer.class).convert(input_Short_null));
    }

    @Test
    public void test_as_Byte() {
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_String));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_byte));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_Byte));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_double));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_Double));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_float));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_Float));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_BigDecimal));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_int));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_Integer));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_long));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_Long));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_short));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_Short));
        assertEquals(input_Byte, TypeConverter.as(Byte.class).convert(input_Short));
        assertEquals(Byte.valueOf((byte) 0), TypeConverter.as(Byte.class).convert(false));
        assertEquals(Byte.valueOf((byte) 1), TypeConverter.as(Byte.class).convert(true));
    }

    @Test
    public void test_as_Byte_default() {
        assertEquals(input_Byte_null, TypeConverter.as(Byte.class).convert(input_String_null));
        assertEquals(input_Byte_default, TypeConverter.as(Byte.class).convert(input_byte_default));
        assertEquals(input_Byte_null, TypeConverter.as(Byte.class).convert(input_Byte_null));
        assertEquals(input_Byte_default, TypeConverter.as(Byte.class).convert(input_double_default));
        assertEquals(input_Byte_null, TypeConverter.as(Byte.class).convert(input_Double_null));
        assertEquals(input_Byte_default, TypeConverter.as(Byte.class).convert(input_float_default));
        assertEquals(input_Byte_null, TypeConverter.as(Byte.class).convert(input_Float_null));
        assertEquals(input_Byte_null, TypeConverter.as(Byte.class).convert(input_BigDecimal_null));
        assertEquals(input_Byte_default, TypeConverter.as(Byte.class).convert(input_int_default));
        assertEquals(input_Byte_null, TypeConverter.as(Byte.class).convert(input_Integer_null));
        assertEquals(input_Byte_default, TypeConverter.as(Byte.class).convert(input_long_default));
        assertEquals(input_Byte_null, TypeConverter.as(Byte.class).convert(input_Long_null));
        assertEquals(input_Byte_default, TypeConverter.as(Byte.class).convert(input_short_default));
        assertEquals(input_Byte_null, TypeConverter.as(Byte.class).convert(input_Short_null));
        assertEquals(input_Byte_default, TypeConverter.as(Byte.class).convert(input_boolean_default));
        assertEquals(input_Byte_null, TypeConverter.as(Byte.class).convert(input_Boolean_null));
    }

    @Test
    public void test_as_Double() {
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_String));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_byte));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_Byte));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_double));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_Double));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_float));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_Float));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_BigDecimal));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_int));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_Integer));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_long));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_Long));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_short));
        assertEquals(input_Double, TypeConverter.as(Double.class).convert(input_Short));
    }

    @Test
    public void test_as_Double_default() {
        assertEquals(input_Double_null, TypeConverter.as(Double.class).convert(input_String_null));
        assertEquals(input_Double_default, TypeConverter.as(Double.class).convert(input_byte_default));
        assertEquals(input_Double_null, TypeConverter.as(Double.class).convert(input_Byte_null));
        assertEquals(input_Double_default, TypeConverter.as(Double.class).convert(input_double_default));
        assertEquals(input_Double_null, TypeConverter.as(Double.class).convert(input_Double_null));
        assertEquals(input_Double_default, TypeConverter.as(Double.class).convert(input_float_default));
        assertEquals(input_Double_null, TypeConverter.as(Double.class).convert(input_Float_null));
        assertEquals(input_Double_null, TypeConverter.as(Double.class).convert(input_BigDecimal_null));
        assertEquals(input_Double_default, TypeConverter.as(Double.class).convert(input_int_default));
        assertEquals(input_Double_null, TypeConverter.as(Double.class).convert(input_Integer_null));
        assertEquals(input_Double_default, TypeConverter.as(Double.class).convert(input_long_default));
        assertEquals(input_Double_null, TypeConverter.as(Double.class).convert(input_Long_null));
        assertEquals(input_Double_default, TypeConverter.as(Double.class).convert(input_short_default));
        assertEquals(input_Double_null, TypeConverter.as(Double.class).convert(input_Short_null));
    }

    @Test
    public void test_as_Float() {
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_String));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_byte));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_Byte));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_double));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_Double));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_float));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_Float));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_BigDecimal));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_int));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_Integer));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_long));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_Long));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_short));
        assertEquals(input_Float, TypeConverter.as(Float.class).convert(input_Short));
    }

    @Test
    public void test_as_Float_default() {
        assertEquals(input_Float_null, TypeConverter.as(Float.class).convert(input_String_null));
        assertEquals(input_Float_default, TypeConverter.as(Float.class).convert(input_byte_default));
        assertEquals(input_Float_null, TypeConverter.as(Float.class).convert(input_Byte_null));
        assertEquals(input_Float_default, TypeConverter.as(Float.class).convert(input_double_default));
        assertEquals(input_Float_null, TypeConverter.as(Float.class).convert(input_Double_null));
        assertEquals(input_Float_default, TypeConverter.as(Float.class).convert(input_float_default));
        assertEquals(input_Float_null, TypeConverter.as(Float.class).convert(input_Float_null));
        assertEquals(input_Float_null, TypeConverter.as(Float.class).convert(input_BigDecimal_null));
        assertEquals(input_Float_default, TypeConverter.as(Float.class).convert(input_int_default));
        assertEquals(input_Float_null, TypeConverter.as(Float.class).convert(input_Integer_null));
        assertEquals(input_Float_default, TypeConverter.as(Float.class).convert(input_long_default));
        assertEquals(input_Float_null, TypeConverter.as(Float.class).convert(input_Long_null));
        assertEquals(input_Float_default, TypeConverter.as(Float.class).convert(input_short_default));
        assertEquals(input_Float_null, TypeConverter.as(Float.class).convert(input_Short_null));
    }

    @Test
    public void test_as_BigDecimal() {
        assertEquals(input_BigDecimal_double, BigDecimal.valueOf(3.0d));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_String));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_byte));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_Byte));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_double));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_Double));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_float));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_Float));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_BigDecimal));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_int));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_Integer));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_long));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_Long));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_short));
        assertEquals(input_BigDecimal, TypeConverter.as(BigDecimal.class).convert(input_Short));
    }

    @Test
    public void test_as_BigDecimal_default() {
        assertEquals(input_BigDecimal_null, TypeConverter.as(BigDecimal.class).convert(input_String_null));
        assertEquals(input_BigDecimal_default, TypeConverter.as(BigDecimal.class).convert(input_byte_default));
        assertEquals(input_BigDecimal_null, TypeConverter.as(BigDecimal.class).convert(input_Byte_null));
        assertEquals(input_BigDecimal_default, TypeConverter.as(BigDecimal.class).convert(input_double_default));
        assertEquals(input_BigDecimal_null, TypeConverter.as(BigDecimal.class).convert(input_Double_null));
        assertEquals(input_BigDecimal_default, TypeConverter.as(BigDecimal.class).convert(input_float_default));
        assertEquals(input_BigDecimal_null, TypeConverter.as(BigDecimal.class).convert(input_Float_null));
        assertEquals(input_BigDecimal_null, TypeConverter.as(BigDecimal.class).convert(input_BigDecimal_null));
        assertEquals(input_BigDecimal_default, TypeConverter.as(BigDecimal.class).convert(input_int_default));
        assertEquals(input_BigDecimal_null, TypeConverter.as(BigDecimal.class).convert(input_Integer_null));
        assertEquals(input_BigDecimal_default, TypeConverter.as(BigDecimal.class).convert(input_long_default));
        assertEquals(input_BigDecimal_null, TypeConverter.as(BigDecimal.class).convert(input_Long_null));
        assertEquals(input_BigDecimal_default, TypeConverter.as(BigDecimal.class).convert(input_short_default));
        assertEquals(input_BigDecimal_null, TypeConverter.as(BigDecimal.class).convert(input_Short_null));
    }

    @Test
    public void test_as_Long() {
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_String));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_byte));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_Byte));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_double));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_Double));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_float));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_Float));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_BigDecimal));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_int));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_Integer));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_long));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_Long));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_short));
        assertEquals(input_Long, TypeConverter.as(Long.class).convert(input_Short));
    }

    @Test
    public void test_as_Long_default() {
        assertEquals(input_Long_null, TypeConverter.as(Long.class).convert(input_String_null));
        assertEquals(input_Long_default, TypeConverter.as(Long.class).convert(input_byte_default));
        assertEquals(input_Long_null, TypeConverter.as(Long.class).convert(input_Byte_null));
        assertEquals(input_Long_default, TypeConverter.as(Long.class).convert(input_double_default));
        assertEquals(input_Long_null, TypeConverter.as(Long.class).convert(input_Double_null));
        assertEquals(input_Long_default, TypeConverter.as(Long.class).convert(input_float_default));
        assertEquals(input_Long_null, TypeConverter.as(Long.class).convert(input_Float_null));
        assertEquals(input_Long_null, TypeConverter.as(Long.class).convert(input_BigDecimal_null));
        assertEquals(input_Long_default, TypeConverter.as(Long.class).convert(input_int_default));
        assertEquals(input_Long_null, TypeConverter.as(Long.class).convert(input_Integer_null));
        assertEquals(input_Long_default, TypeConverter.as(Long.class).convert(input_long_default));
        assertEquals(input_Long_null, TypeConverter.as(Long.class).convert(input_Long_null));
        assertEquals(input_Long_default, TypeConverter.as(Long.class).convert(input_short_default));
        assertEquals(input_Long_null, TypeConverter.as(Long.class).convert(input_Short_null));
    }

    @Test
    public void test_as_Short() {
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_String));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_byte));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_Byte));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_double));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_Double));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_float));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_Float));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_BigDecimal));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_int));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_Integer));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_long));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_Long));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_short));
        assertEquals(input_Short, TypeConverter.as(Short.class).convert(input_Short));
    }

    @Test
    public void test_as_Short_default() {
        assertEquals(input_Short_null, TypeConverter.as(Short.class).convert(input_String_null));
        assertEquals(input_Short_default, TypeConverter.as(Short.class).convert(input_byte_default));
        assertEquals(input_Short_null, TypeConverter.as(Short.class).convert(input_Byte_null));
        assertEquals(input_Short_default, TypeConverter.as(Short.class).convert(input_double_default));
        assertEquals(input_Short_null, TypeConverter.as(Short.class).convert(input_Double_null));
        assertEquals(input_Short_default, TypeConverter.as(Short.class).convert(input_float_default));
        assertEquals(input_Short_null, TypeConverter.as(Short.class).convert(input_Float_null));
        assertEquals(input_Short_null, TypeConverter.as(Short.class).convert(input_BigDecimal_null));
        assertEquals(input_Short_default, TypeConverter.as(Short.class).convert(input_int_default));
        assertEquals(input_Short_null, TypeConverter.as(Short.class).convert(input_Integer_null));
        assertEquals(input_Short_default, TypeConverter.as(Short.class).convert(input_long_default));
        assertEquals(input_Short_null, TypeConverter.as(Short.class).convert(input_Long_null));
        assertEquals(input_Short_default, TypeConverter.as(Short.class).convert(input_short_default));
        assertEquals(input_Short_null, TypeConverter.as(Short.class).convert(input_Short_null));
    }

    @Test
    public void test_as_Character() {
        assertEquals((Character) input_String.charAt(0), TypeConverter.as(Character.class).convert(input_String));
        assertEquals(input_Char, TypeConverter.as(Character.class).convert(input_char));
        assertEquals(input_Char, TypeConverter.as(Character.class).convert(input_Char));
    }

    @Test
    public void test_as_Character_default() {
        assertEquals(input_Char_null, TypeConverter.as(Character.class).convert(input_String_null));
        assertEquals(input_Char_default, TypeConverter.as(Character.class).convert(input_char_default));
        assertEquals(input_Char_null, TypeConverter.as(Character.class).convert(input_Char_null));
    }

    @Test
    public void test_as_Boolean() {
        assertEquals(input_boolean, TypeConverter.as(Boolean.class).convert(input_boolean));
        assertEquals(input_Boolean, TypeConverter.as(Boolean.class).convert(input_Boolean));
        assertEquals(input_Boolean_default, TypeConverter.as(Boolean.class).convert(input_Boolean_default));
        assertEquals(input_Boolean_null, TypeConverter.as(Boolean.class).convert(input_Boolean_null));

        assertEquals(input_Boolean_default, TypeConverter.as(Boolean.class).convert(input_String));
        assertEquals(input_Boolean, TypeConverter.as(Boolean.class).convert(input_String_default_boolean));
        assertEquals(input_Boolean, TypeConverter.as(Boolean.class).convert(input_String_default_boolean_number));
        assertEquals(input_Boolean_null, TypeConverter.as(Boolean.class).convert(input_String_null));
    }
}
