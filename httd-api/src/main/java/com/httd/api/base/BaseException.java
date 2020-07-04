/**  
* @Title: MyException.java  
* @Description:   
* @author lsc  
* @date 2018年7月30日  
* @version 1.0  
* @Copyright:Copyright Taikanglife.All Rights Reserved 
* 注意：本内容仅限于泰康保险集团内部传阅，禁止外泄以及用于其他的商业 
*/
package com.httd.api.base;

import com.httd.api.enums.ResultEnum;

/**
 * 自定义异常
 * 
 * @author w_liusc
 *
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String code;

	private String msg;

	private Object data;

	public BaseException(ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.msg = resultEnum.getMsg();
	}

	public BaseException(ResultEnum resultEnum, Object data) {
		this.code = resultEnum.getCode();
		this.msg = resultEnum.getMsg();
		this.data = data;
	}

	public BaseException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public BaseException(String msg) {
		this.code = ResultEnum.TOAST_ERROR.getCode();
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
