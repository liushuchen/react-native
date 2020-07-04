package com.httd.api.mapper.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户列表
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 头像路径
     */
    private String headImage;

    /**
     * 最后一次登录的ip地址
     */
    private String loginIp;

    /**
     * 上一次登录的时间
     */
    private LocalDateTime loginTime;

    /**
     * 城市-区编码
     */
    private String areaNo;

    /**
     * 用户状态 0:正常 1:异常
     */
    private Integer userState;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 推送唯一标识
     */
    private String clientId;


}
