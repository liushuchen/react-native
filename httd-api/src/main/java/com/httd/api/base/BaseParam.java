package com.httd.api.base;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface BaseParam {
 
    /**
     * 入参是否解密，默认解密
     */
    boolean inDecode() default true;
 
    /**
     * 出参是否加密，默认加密
     */
    boolean outEncode() default true;
    
    /**
     * 入参token验证
     * @return
     */
    boolean inToken() default true;
}