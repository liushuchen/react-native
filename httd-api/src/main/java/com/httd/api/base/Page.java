package com.httd.api.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Page implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	// 每页显示条数
	private Integer pageSize = 20;

	// 开始条数
	private Integer indexNo = 1;

	// 当前页数
	private Integer pageNo = 1;

	// 总条数
	private Integer totalNo = 0;

	// 是否已经没有数据
	@JsonIgnore
	private Boolean success = false;

	public Boolean getSuccess() {
		if ((pageNo - 1) * pageSize >= totalNo) {
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getIndexNo() {
		indexNo = (pageNo - 1) * pageSize;
		return indexNo;
	}

	public void setIndexNo(Integer indexNo) {
		this.indexNo = indexNo;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getTotalNo() {
		return totalNo;
	}

	public void setTotalNo(Integer totalNo) {
		this.totalNo = totalNo;
	}

}
