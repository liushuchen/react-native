package com.httd.api.mapper.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 首页轮播图
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_home_banner")
public class HomeBanner implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 轮播图id
     */
    @TableId(value = "banner_id", type = IdType.AUTO)
    private Integer bannerId;

    /**
     * 轮播图名称
     */
    private String bannerName;

    /**
     * 轮播图图片
     */
    private String bannerImage;

    /**
     * 轮播图顺序
     */
    private Integer bannerIndex;

    /**
     * 轮播图状态0:显示  1:不显示
     */
    private Integer bannerStatus;

    /**
     * 跳转类型:0:点击没有反应 1:跳转路由
     */
    private Integer jumpType;

    /**
     * 跳转参数
     */
    private String jumpPath;


}
