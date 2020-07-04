package com.httd.api.business.home.entity;

import com.httd.api.base.BaseConstant;
import lombok.Data;

import java.io.Serializable;

@Data
public class FindHomeRecommendListDTO implements Serializable {
    private static final long serialVersionUID = -4299365355048911390L;

    private String recommendName;

    private String recommendImage;

    private Integer jumpType;

    private String jumpPath;

    private String imagePrefix= BaseConstant.IMAGE_PREFIX;
}
