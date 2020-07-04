package com.httd.api.enums;

import com.httd.api.base.ICommonEnum;

public enum AccountEnum implements ICommonEnum {
    MAIN("0", "主账号"),SUB("1", "子账号");

    private String key;

    private String value;

    AccountEnum(String key, String value) {
        this.value = value;
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
