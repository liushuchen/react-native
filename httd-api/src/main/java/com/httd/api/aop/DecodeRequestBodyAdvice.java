package com.httd.api.aop;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.httd.api.business.redis.IRedisService;
import com.httd.api.base.BaseParam;
import com.httd.api.base.BaseController;
import com.httd.api.base.BaseException;
import com.httd.api.base.BaseVO;
import com.httd.api.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * 针对请求参数进行解密
 *
 * @author w_liusc
 */
@Slf4j
@ControllerAdvice
public class DecodeRequestBodyAdvice extends BaseController implements RequestBodyAdvice {

    private static final String UTF_8 = "UTF-8";

    @Value("${smarthome.refresh.state}")
    private boolean isRefreshState;

    @Value("${smarthome.request.state}")
    private boolean isRequestState;

    @Value("${smarthome.request.header}")
    private boolean isRequestHeader;

    @Autowired
    private IRedisService redisService;

    @Override
    public boolean supports(MethodParameter methodParameter, Type type,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        return isRequestState;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter,
                                  Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        throw new BaseException("请求体数据不能为空");
    }


    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter methodParameter, Type type,
                                           Class<? extends HttpMessageConverter<?>> aClass) throws IOException {

        // 是否吧包含这个注解
        if (methodParameter.getMethod().isAnnotationPresent(BaseParam.class)) {
            InputStream stream = inputMessage.getBody();
            String body = IoUtil.read(stream, UTF_8);
            stream.close();
            // 获取注解配置的包含和去除字段
            BaseParam baseParam = methodParameter.getMethodAnnotation(BaseParam.class);
            // 入参是否需验证token
            if (baseParam.inToken() && isRequestHeader) {
                BaseVO base =JSONUtil.toBean(body,BaseVO.class);
                try {
                    if (StrUtil.isBlank(base.getToken()))
                        throw new BaseException(ResultEnum.TOKEN_ERROR);
                    log.info("获取用户的token:{}",base.getToken());
                    redisService.findAdminIdByToken(base.getToken());
                } catch (Exception e) {
                    throw new BaseException(ResultEnum.TOKEN_ERROR);
                }

            }
            // 处理入参
            if (baseParam.inDecode()) {
                log.info(".....解密入参开始.....");
                log.info(".....解密入参结束.....");
            }
            return new HttpInputMessage() {
                @Override
                public InputStream getBody() throws IOException {
                    return new ByteArrayInputStream(body.getBytes(UTF_8));
                }

                @Override
                public HttpHeaders getHeaders() {
                    return inputMessage.getHeaders();
                }
            };
        }
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter methodParameter,
                                Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.info("方法[{}]读取处理后请求的数据:\n{}", methodParameter.getMethod().getName(), JSONUtil.toJsonStr(body));
        return body;
    }

}
