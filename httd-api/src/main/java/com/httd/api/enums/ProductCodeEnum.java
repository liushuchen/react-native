/**
 * @Title: ApiResultEnum.java
 * @Description:
 * @author lsc
 * @date 2018年7月18日
 * @version 1.0
 * @Copyright:Copyright Taikanglife.All Rights Reserved
 * 注意：本内容仅限于泰康保险集团内部传阅，禁止外泄以及用于其他的商业
 */
package com.httd.api.enums;

import com.httd.api.base.ICommonEnum;

/**
 * 产品编码
 *
 * @author lsc
 */
public enum ProductCodeEnum implements ICommonEnum {

    PRODUCT_01("01", "四路通断"), PRODUCT_02("02", "两路调光"), PRODUCT_03("03", "四键面板"),
    PRODUCT_04("04", "四路干接点安防模块"), PRODUCT_05("05", "感应器"), PRODUCT_06("06", "杜亚开合窗帘"),
    PRODUCT_07("07", "豪力士指纹门锁"), PRODUCT_08("08", "modbus协议空调"), PRODUCT_09("09", "八键面板"),
    PRODUCT_10("010", "丙申开合窗帘"), PRODUCT_11("011", "萤石云监控"), PRODUCT_12("012", "音乐"),
    PRODUCT_13("013", "安防控制"), PRODUCT_14("014", "F路调光"), PRODUCT_15("015", "A0电机控制"),
    PRODUCT_16("016", "三合一八键环境面板"), PRODUCT_17("017", "A地暖控制"), PRODUCT_18("018", "A新风控制"),
    PRODUCT_19("019", "环境探测器"), PRODUCT_20("020", "F键面板"), PRODUCT_21("021", "F路通断"),
    PRODUCT_22("022", "A定时控制"), PRODUCT_23("023", "F路影视控制"), PRODUCT_24("024", "A音乐控制"),
    PRODUCT_25("025", "F双色控制"), PRODUCT_26("026", "F三色控制"), PRODUCT_27("027", "W1智能插座"),
    PRODUCT_28("028", "W2智能插座"), PRODUCT_99("099", "子场景");

    private String key;

    private String value;

    ProductCodeEnum(String key, String value) {
        this.key = key;// 产品编码
        this.value = value;// 产品名称
    }
    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
