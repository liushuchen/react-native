package com.httd.api.enums;

public enum ResultEnum {
	
	UNKONW_ERROR("-1", "服务器错误"),
	SUCCESS("0", "SUCCESS"),REQUEST_ERROR("3", "非法的请求"),
	TOAST_ERROR("1", "请求出错,Toast提示"),
	TOKEN_ERROR("6", "用户信息超时,或者当前账号在其他地方登录");

	private String code;

	private String msg;

	ResultEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
