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

    private String input_String = "3"; //$NON-NLS-1$

    private String input_String_double = "3.0"; //$NON-NLS-1$

    private String input_String_empty = ""; //$NON-NLS-1$

    private String input_String_default = "0"; //$NON-NLS-1$

    private String input_String_default_double = "0.0"; //$NON-NLS-1$

    private String input_String_default_char = "a"; //$NON-NLS-1$

    private String input_String_default_boolean = "true"; //$NON-NLS-1$

    private String input_String_default_boolean_number = "1"; //$NON-NLS-1$

    private String input_String_null = null;

    private java.nio.ByteBuffer input_ByteBuffer_null = null;

    private byte input_byte = 3;

    private byte input_byte_default = 0;

    private Byte input_Byte = 3;

    private Byte input_Byte_null = null;

    private Byte input_Byte_default = 0;

    private boolean input_boolean = true;

    private boolean input_boolean_default = false;

    private Boolean input_Boolean = true;

    private Boolean input_Boolean_default = false;

    private Boolean input_Boolean_null = null;

    private double input_double = 3.0d;

    private double input_double_default = 0d;

    private Double input_Double = 3.0D;

    private Double input_Double_null = null;

    private Double input_Double_default = 0D;

    private float input_float = 3.0f;

    private float input_float_default = 0f;

    private Float input_Float = 3.0F;

    private Float input_Float_null = null;

    private Float input_Float_default = 0F;

    private BigDecimal input_BigDecimal = new BigDecimal(3);

    private BigDecimal output_BigDecimal_withScale = new BigDecimal(3).setScale(5);

    // weird error case
    private BigDecimal input_BigDecimal_double = new BigDecimal(((Double) 3.000D).toString());

    private BigDecimal input_BigDecimal_null = null;

    private BigDecimal input_BigDecimal_default = new BigDecimal(0);

    private BigDecimal input_BigDecimal_defaultdouble = BigDecimal.valueOf(0.0d);

    private int input_int = 3;

    private int input_int_default = 0;

    private Integer input_Integer = 3;

    private Integer input_Integer_null = null;

    private Integer input_Integer_default = 0;

    private long input_long = 3l;

    private long input_long_default = 0l;

    private Long input_Long = 3L;

    private Long input_Long_null = null;

    private Long input_Long_default = 0L;

    private short input_short = 3;

    private short input_short_default = 0;

    private Short input_Short = 3;

    private Short input_Short_null = null;

    private Short input_Short_default = 0;

    private char input_char = 'a';

    private char input_char_default = ' ';

    private Character input_Char = 'a';

    private Character input_Char_null = null;

    private Character input_Char_default = ' ';

    private String object_test = "a"; //$NON-NLS-1$

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
