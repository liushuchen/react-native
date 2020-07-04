package com.httd.api.mapper;

import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeBannerListDTO;
import com.httd.api.mapper.po.HomeBanner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 首页轮播图 Mapper 接口
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
public interface HomeBannerMapper extends BaseMapper<HomeBanner> {

    /**
     * 获取首页伦比图
     * @return
     */
    List<FindHomeBannerListDTO> findHomeBannerList(BaseVO vo) throws Exception;
}
