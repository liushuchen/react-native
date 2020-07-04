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
 * app关于页面数据
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_app_about")
public class AppAbout implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;

    /**
     * 公司名称
     */
    private String company;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 座机
     */
    private String landline;

    /**
     * 邮箱
     */
    private String mailbox;

    private String qq;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 微信公众号二维码连接
     */
    private String wxPublicUrl;

    /**
     * 官网连接
     */
    private String website;

    /**
     * 公司描述
     */
    private String introduce;

    /**
     * app下载页面地址图片地址
     */
    private String appUrl;

    /**
     * 公司logo图片路径
     */
    private String logoUrl;

    /**
     * 删除状态0:正常 1:关闭
     */
    private Integer deleteState;


}
