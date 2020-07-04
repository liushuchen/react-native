package com.httd.api.enums;

import com.httd.api.base.ICommonEnum;

public enum GatewayEnum implements ICommonEnum {

    Gateway_00("0", "主机"),Gateway_01("1", "单品插座W1"),Gateway_02("2", "单品插座W2");

    private String key;

    private String value;

    GatewayEnum(String key, String value) {
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
