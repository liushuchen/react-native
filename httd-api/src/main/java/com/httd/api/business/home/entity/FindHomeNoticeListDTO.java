package com.httd.api.business.home.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class FindHomeNoticeListDTO implements Serializable {
    private static final long serialVersionUID = -6069897174324579312L;

    private String noticeTitle;

    private String noticeContent;

    private Integer jumpType;

    private String jumpPath;
}
