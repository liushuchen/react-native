package com.httd.api.base;

import java.io.Serializable;

import com.httd.api.enums.ResultEnum;
import lombok.Data;

@Data
public class BaseResult implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -1147019373557091131L;

	/**
	 * 数据返回码
	 */
	private String code;

	/**
	 * 提示信息
	 */
	private String message;

	/**
	 * 数据
	 */
	private Object data;

	/**
	 * 当前页数
	 */
	private Page page;

	public BaseResult(ResultEnum resultEnum) {
		super();
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMsg();
		this.data = null;
	}

	public BaseResult(ResultEnum resultEnum, Object data) {
		super();
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMsg();
		this.data = data;
	}

	public BaseResult(String code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public BaseResult(String code, String message, Object data, Page page) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
		this.page = page;
	}
}
