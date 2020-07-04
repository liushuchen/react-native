package com.httd.api.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BaseSelect implements Serializable {
	/**
	 * @描述
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String selectId;
}
