package org.talend.daikon.container;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

/**
 * To find more test, please refer to TypeCOnverterTest
 *
 */
public class BigDecimalConverterTest {

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

    BigDecimal output_BigDecimal_withScale = new BigDecimal(3).setScale(5);

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
    public void test_asBigDecimal_scale() {
        // the only one impacted by the scale value
        assertEquals(output_BigDecimal_withScale, TypeConverter.asBigDecimal().withScale(5).convert(input_BigDecimal));

        // scale is unused
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_String));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_byte));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_Byte));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_double));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_Double));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_float));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_Float));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_int));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_Integer));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_long));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_Long));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_short));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withScale(5).convert(input_Short));
    }

    @Test
    public void test_asBigDecimal_scale_roundingmode() {
        // the only one impacted by the scale value
        assertEquals(output_BigDecimal_withScale,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_BigDecimal));

        // scale is unused
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_String));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_byte));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_Byte));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_double));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_Double));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_float));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_Float));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_int));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_Integer));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_long));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_Long));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_short));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withScale(5).withRoundingMode(RoundingMode.CEILING).convert(input_Short));
    }

    @Test
    public void test_asBigDecimal_precision() {
        // the only one impacted by the precision value
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_BigDecimal));

        // Precision is unused
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_String));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_byte));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_Byte));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_double));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_Double));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_float));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_Float));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_int));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_Integer));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_long));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_Long));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_short));
        assertEquals(input_BigDecimal, TypeConverter.asBigDecimal().withPrecision(5).convert(input_Short));
    }

    @Test
    public void test_asBigDecimal_precision_roundingmode() {
        // the only one impacted by the Precision value
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_BigDecimal));

        // Precision is unused
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_String));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_byte));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_Byte));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_double));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_Double));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_float));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_Float));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_int));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_Integer));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_long));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_Long));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_short));
        assertEquals(input_BigDecimal,
                TypeConverter.asBigDecimal().withPrecision(5).withRoundingMode(RoundingMode.CEILING).convert(input_Short));
    }

}
