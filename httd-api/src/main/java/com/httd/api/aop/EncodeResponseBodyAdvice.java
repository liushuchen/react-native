package com.httd.api.aop;

import cn.hutool.json.JSONUtil;
import com.httd.api.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 针对返回参数进行加密
 * 
 * @author w_liusc
 *
 */
@Slf4j
@ControllerAdvice
public class EncodeResponseBodyAdvice extends BaseController implements ResponseBodyAdvice<Object> {

	//private final ObjectMapper objectMapper = new ObjectMapper();

	@Value("${smarthome.response.state}")
	private boolean isResponseState;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
		log.info(".....加密返回参数开始.....");

		
		log.info(".....加密返回参数结束.....");
		log.info("方法[{}]返回加密数据:\n{}",returnType.getMethod().getName(), JSONUtil.toJsonStr(body));
		return body;
	}

}