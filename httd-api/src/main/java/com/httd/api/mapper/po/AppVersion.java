package com.httd.api.mapper.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * app版本信息
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_app_version")
public class AppVersion implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 版本ID
     */
    @TableId(value = "version_id", type = IdType.AUTO)
    private Integer versionId;

    /**
     * 安卓最低支持版本
     */
    private Integer androidMin;

    /**
     * 安卓最新版本
     */
    private Integer androidMax;

    /**
     * 安卓版本
     */
    private String androidVersion;

    /**
     * 苹果版本描述
     */
    private String iosVersion;

    /**
     * 安卓下载路径
     */
    private String androidUrl;

    /**
     * 安卓更新描述
     */
    private String androidDescribe;

    /**
     * iOS最低版本
     */
    private Integer iosMin;

    /**
     * ios最高版本
     */
    private Integer iosMax;

    /**
     * ios下载路径
     */
    private String iosUrl;

    /**
     * 下载apk路径
     */
    private String downloadApk;

    /**
     * ios更新描述
     */
    private String iosDescribe;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否启用 0:不启用  1:启用
     */
    private Integer deleteState;


}
