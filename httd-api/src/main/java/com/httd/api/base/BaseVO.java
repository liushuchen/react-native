package com.httd.api.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String token;

	//@NotBlank(message = "请求的版本号不能为空")
	private String reqVersion;

	//@NotBlank(message = "请求的渠道不能为空")
	private String reqChannel;

	private String reqModel;

	private Long adminId;

	private Page page =new Page();
}
