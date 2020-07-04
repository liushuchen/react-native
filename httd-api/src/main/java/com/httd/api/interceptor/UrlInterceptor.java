package com.httd.api.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@Component
public class UrlInterceptor implements HandlerInterceptor {


	/**
	 * 进入controller层之前拦截请求 preHandle=>请求处理前拦截，处理通过返回true，否则返回false不进行处理
	 * postHandle=>请求处理后拦截(页面渲染前)，处理通过返回true，否则返回false afterCompletion=>请求处理后拦截，(同上)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {
	}
}
