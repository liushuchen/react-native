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
 * 首页公告
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_home_notice")
public class HomeNotice implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 轮播图id
     */
    @TableId(value = "notice_id", type = IdType.AUTO)
    private Long noticeId;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 公告状态0:显示  1:不显示
     */
    private Integer noticeStatus;

    /**
     * 发布时间
     */
    private LocalDateTime sendTime;

    /**
     * 跳转类型:0:点击没有反应 1:跳转路由
     */
    private Integer jumpType;

    /**
     * 跳转参数
     */
    private String jumpPath;


}
