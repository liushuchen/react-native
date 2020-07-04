package com.httd.api.mapper.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 协议列表
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_agreement")
public class Agreement implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 协议id
     */
    @TableId(type = IdType.AUTO,value = "agreement_id")
    private Integer agreementId;

    /**
     * 协议类型0:注册协议
     */
    private Integer type;

    /**
     * 协议内容
     */
    private String content;


}
