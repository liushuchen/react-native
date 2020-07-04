package com.httd.api.business.config.entity;

import com.httd.api.base.BaseVO;
import lombok.Data;

import java.io.Serializable;
@Data
public class UpdateAgreementVO extends BaseVO implements Serializable {
    private static final long serialVersionUID = -8428967233341406832L;

    private String content;

    private Integer type;
}
