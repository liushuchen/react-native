package com.httd.api.business.config.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class FindAppAboutDTO implements Serializable {
    private static final long serialVersionUID = 7461813811067415170L;
    /**
     * 主键ID
     */
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
