package com.httd.api.mapper;

import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeRecommendListDTO;
import com.httd.api.mapper.po.HomeRecommend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 首页推荐 Mapper 接口
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-27
 */
public interface HomeRecommendMapper extends BaseMapper<HomeRecommend> {

    /**
     * 获取首页推荐列表
     * @param vo
     * @return
     */
    List<FindHomeRecommendListDTO> findHomeRecommendList(BaseVO vo) throws  Exception;
}
