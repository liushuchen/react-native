package com.httd.api.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 发送短信工具
 */
@Slf4j
public class SmsUtil {
    private static String username = "api";

    private static String password = "key-ea0a01e28faae682144170e1cf71e3f3";

    private static String sendurl = "http://sms-api.luosimao.com/v1/send.json";


    public static boolean sendSms(String phone, String template) {
        Map<String, Object> formMap = new HashMap<>();
        formMap.put("mobile", phone);
        formMap.put("message", template);
        String result = HttpUtil.createPost(sendurl).basicAuth(username, password).form(formMap).execute().body();
        log.info("请求短信平台发送验证码结果:{}", result);
        int error = (int) JSONUtil.parseObj(result).get("error");
        return error == 0 ? true : false;
    }

}
