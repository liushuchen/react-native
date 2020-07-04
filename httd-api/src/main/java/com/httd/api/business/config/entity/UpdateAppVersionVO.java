package com.httd.api.business.config.entity;

import com.httd.api.base.BaseVO;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateAppVersionVO extends BaseVO implements Serializable {
    private static final long serialVersionUID = -3812539573680606791L;

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

}
