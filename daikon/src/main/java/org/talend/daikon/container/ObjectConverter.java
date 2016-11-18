package org.talend.daikon.container;

public class ObjectConverter extends Converter<Object> {

    @Override
    public Object convert(Object value) {
        if (value == null) {
            return returnDefaultValue();
        } else {
            return value;
        }
    }
}
