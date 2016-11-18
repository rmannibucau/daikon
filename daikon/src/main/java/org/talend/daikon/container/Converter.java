package org.talend.daikon.container;

import java.util.HashMap;
import java.util.Map;

public abstract class Converter<T> {

    private Map<String, Object> properties = new HashMap<>();

    public abstract T convert(Object value);

    public void with(String key, Object value) {
        properties.put(key, value);
    }

    public Object get(String key) {
        return properties.get(key);
    }

}
