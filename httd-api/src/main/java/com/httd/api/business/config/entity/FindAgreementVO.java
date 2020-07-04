package com.httd.api.business.config.entity;

import com.httd.api.base.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
public class FindAgreementVO extends BaseVO implements Serializable {
    private static final long serialVersionUID = 1519441092250674938L;
    @NotNull(message = "协议类型不能为空")
    private Integer type;
}
