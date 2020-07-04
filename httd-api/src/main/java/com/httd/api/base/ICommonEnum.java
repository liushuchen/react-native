package com.httd.api.base;

import java.util.EnumSet;
import java.util.Objects;

public interface ICommonEnum {
    String getValue();

    String getKey();

    static <E extends Enum<E> & ICommonEnum> E getValueEnmu(String value, Class<E> clazz) {
        Objects.requireNonNull(value);
        EnumSet<E> all = EnumSet.allOf(clazz);
        return all.stream().filter(e -> e.getValue().equals(value)).findFirst().orElse(null);
    }

    static <E extends Enum<E> & ICommonEnum> E getKeyEnmu(String key, Class<E> clazz) {
        Objects.requireNonNull(key);
        EnumSet<E> all = EnumSet.allOf(clazz);
        return all.stream().filter(e -> e.getKey().equals(key)).findFirst().orElse(null);
    }
}