package com.httd.api.business.home.entity;

import com.httd.api.base.BaseConstant;
import lombok.Data;

import java.io.Serializable;

@Data
public class FindHomeMenuListDTO implements Serializable {
    private static final long serialVersionUID = 5928494625256071306L;

    private String menuName;

    private String menuImage;

    private String jumpType;

    private String jumpPath;

    private String imagePrefix= BaseConstant.IMAGE_PREFIX;
}
