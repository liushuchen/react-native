package com.httd.api.aop;


import com.httd.api.base.BaseController;
import com.httd.api.base.BaseException;
import com.httd.api.base.BaseResult;
import com.httd.api.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.xml.bind.ValidationException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 全局异常捕获
 * 
 * @author w_zhanglc
 *
 */
@Slf4j
@ControllerAdvice
public class ExceptionAdvice extends BaseController {

	/**
	 * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	}

	// 声明要捕获的异常
	@ResponseBody
	@ExceptionHandler(value = ValidationException.class)
	public BaseResult validationExcepitonHandler(ValidationException e) {
		return response(ResultEnum.TOAST_ERROR.getCode(), e.getMessage());
	}

	// 参数异常
	@ResponseBody
	@ExceptionHandler(value = ConstraintViolationException.class)
	public BaseResult constraintViolationExceptionHandler(ConstraintViolationException e) {
		Set<ConstraintViolation<?>> set = e.getConstraintViolations();
		StringBuffer buffer = new StringBuffer();
		for (ConstraintViolation<?> constraintViolation : set) {
			buffer.append(constraintViolation.getMessage());
		}
		return response(ResultEnum.TOAST_ERROR.getCode(), buffer.toString());
	}
	// 参数异常
	@ResponseBody
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public BaseResult methodArgumentNotValidException(MethodArgumentNotValidException e) {
		  List<ObjectError> errors = e.getBindingResult().getAllErrors();
		StringBuffer buffer = new StringBuffer();
		for (ObjectError objectError : errors) {
			buffer.append(objectError.getDefaultMessage());
		}
		return response(ResultEnum.TOAST_ERROR.getCode(), buffer.toString());
	}

	// 参数异常
	@ResponseBody
	@ExceptionHandler(value = BindException.class)
	public BaseResult bindExceptionHandler(BindException e) {
		BindException ex = (BindException) e;
		List<ObjectError> errors = ex.getAllErrors();/* 抛出异常可能不止一个 输出为一个List集合 */
		Set<String> set = new HashSet<>();
		for (ObjectError objectError : errors) {
			set.add(objectError.getDefaultMessage());
		}
		return response(ResultEnum.TOAST_ERROR.getCode(), set.toString());
	}

	// 声明要捕获的异常
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public BaseResult defultExcepitonHandler(Exception e) {
		log.error(e.getMessage(), e);
		return responseFail(ResultEnum.UNKONW_ERROR);
	}

	/**
	 * 自定义异常
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = BaseException.class)
	public BaseResult myExceptionHandler(BaseException ex) {
		return response(ex.getCode(), ex.getMsg(), ex.getData());
	}
}
