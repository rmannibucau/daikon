package org.talend.daikon.container;

public class IntegerConverter extends Converter<Integer> {

    @Override
    public Integer convert(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        } else {
            return Integer.parseInt(value.toString());
        }
    }
}
