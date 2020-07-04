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
 * 首页推荐
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_home_recommend")
public class HomeRecommend implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 推荐id
     */
    @TableId(value = "recommend_id", type = IdType.AUTO)
    private Integer recommendId;

    /**
     * 推荐状态0:正常 1:停用
     */
    private Integer recommendStatus;

    /**
     * 推荐名称
     */
    private String recommendName;

    /**
     * 顺序
     */
    private Integer recommendIndex;

    /**
     * 推荐图片
     */
    private String recommendImage;

    /**
     * 跳转类型
     */
    private Integer jumpType;

    /**
     * 跳转参数
     */
    private String jumpPath;


}
