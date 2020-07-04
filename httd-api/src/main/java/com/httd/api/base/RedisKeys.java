package com.httd.api.base;

public class RedisKeys {

    // 刷新机制
    private static final String SMARTHOME_ADMIN_REFRESH = "smarthome:admin:refresh:";
    // 用户的token
    private static final String SMARTHOME_ADMIN_TOKEN = "smarthome:admin:token:";

    private static final String SMARTHOME_ADMIN_SMSCODE = "smarthome:admin:smscode:";

    public static final String SMARTHOME_APP_TOKEN = "smarthome:app:token:";

    public static String AdminToken(String token) {
        return SMARTHOME_ADMIN_TOKEN + token;
    }

    public static String AppToken(String token) {
        return SMARTHOME_APP_TOKEN + token;
    }

    public static String AdminRefresh(String refresh) {
        return SMARTHOME_ADMIN_REFRESH + refresh;
    }

    public static String SmsCode(Integer codeType,String phone) {
        return SMARTHOME_ADMIN_SMSCODE + codeType+":"+phone;
    }

}
