package com.httd.api.business.home.entity;

import com.httd.api.base.BaseConstant;
import lombok.Data;

import java.io.Serializable;

@Data
public class FindHomeBannerListDTO implements Serializable {
    private static final long serialVersionUID = -1260634979748865385L;

    private String bannerName;

    private String bannerImage;

    private Integer jumpType;

    private String jumpPath;

    private String imagePrefix= BaseConstant.IMAGE_PREFIX;
}
