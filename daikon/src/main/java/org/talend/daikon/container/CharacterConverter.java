package org.talend.daikon.container;

public class CharacterConverter extends Converter<Character> {

    @Override
    public Character convert(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Character) {
            return (Character) value;
        } else {
            return Character.valueOf(value.toString().charAt(0));
        }
    }
}
