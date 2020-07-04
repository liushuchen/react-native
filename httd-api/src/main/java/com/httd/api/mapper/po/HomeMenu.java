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
 * 首页菜单
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_home_menu")
public class HomeMenu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 轮播图id
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单图片
     */
    private String menuImage;

    private Integer menuIndex;

    private Integer menuStatus;

    /**
     * 跳转类型:0:点击没有反应 1:跳转路由
     */
    private Integer jumpType;

    /**
     * 跳转参数
     */
    private String jumpPath;


}
