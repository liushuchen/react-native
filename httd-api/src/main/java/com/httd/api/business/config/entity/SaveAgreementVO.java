package com.httd.api.business.config.entity;

import com.httd.api.base.BaseVO;
import lombok.Data;

import java.io.Serializable;
@Data
public class SaveAgreementVO extends BaseVO implements Serializable {
    private static final long serialVersionUID = -1497568368716309507L;

    /**
     * 协议类型0:注册协议
     */
    private Integer type;

    /**
     * 协议内容
     */
    private String content;
}
