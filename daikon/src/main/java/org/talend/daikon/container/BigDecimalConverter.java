package org.talend.daikon.container;

import java.math.BigDecimal;

public class BigDecimalConverter extends Converter<BigDecimal> {

    // TODO handle precision
    @Override
    public BigDecimal convert(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Byte) {
            return new BigDecimal((Byte) value);
        } else if (value instanceof Double) {
            return new BigDecimal((Double) value);
        } else if (value instanceof Float) {
            return new BigDecimal((Float) value);
        } else if (value instanceof Integer) {
            return new BigDecimal((Integer) value);
        } else if (value instanceof Long) {
            return new BigDecimal((Long) value);
        } else if (value instanceof Short) {
            return new BigDecimal((Short) value);
        } else {
            return new BigDecimal(value.toString());
        }
    }
}
