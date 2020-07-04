package com.httd.api.business.config.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class FindAgreementDTO implements Serializable {
    private static final long serialVersionUID = 1924000307106538557L;

    //协议的内容
    private  String content;

    //协议的id
    private Integer agreementId;

    //协议的类型0:注册协议 1:隐私条款
    private Integer type;
}
