package com.httd.api.business.config.entity;

import com.httd.api.base.BaseVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class FindSmsCodeVO extends BaseVO implements Serializable {
    private static final long serialVersionUID = -3522827197919822387L;
    @NotBlank(message = "手机号不能为空")
    private String phone;
    @NotNull(message = "短信验证吗类型不能为空")
    private Integer codeType;
}
