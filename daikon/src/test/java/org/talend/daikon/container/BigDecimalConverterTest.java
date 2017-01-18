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

    private byte input_byte = 3;

    private Byte input_Byte = 3;

    private double input_double = 3.0d;

    private Double input_Double = 3.0D;

    private float input_float = 3.0f;

    private Float input_Float = 3.0F;

    private BigDecimal input_BigDecimal = new BigDecimal(3);

    private BigDecimal output_BigDecimal_withScale = new BigDecimal(3).setScale(5);

    private int input_int = 3;

    private Integer input_Integer = 3;

    private long input_long = 3l;

    private Long input_Long = 3L;

    private short input_short = 3;

    private Short input_Short = 3;

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
