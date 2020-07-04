package com.httd.api.enums;

public enum StateEnum {

	YES(0, "可以"), NO(1, "不可以");
	private Integer code;

	private String name;

	StateEnum(Integer code, String name) {
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
