package com.httd.api.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeInterceptor {
	public static final String POINT = "execution (* com.httd.api.business.*.controller..*.*(..))";

	@Around(POINT)
	public Object timeAround(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = joinPoint.proceed(joinPoint.getArgs());
		long endTime = System.currentTimeMillis();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		// 打印耗时的信息
		log.info("方法{},请求耗时[{}]毫秒", signature.getName(), endTime - startTime);
		//log.info("方法{},请求返回结果:{}", methodName, obj == null ? "无数据返回" : obj.toString());
		return obj;
	}
}
