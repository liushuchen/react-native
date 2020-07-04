package com.httd.api.enums;

public enum CodeTypeEnum {

	RESET_PWD(0, "修改密码");
	private Integer code;

	private String name;

	CodeTypeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
