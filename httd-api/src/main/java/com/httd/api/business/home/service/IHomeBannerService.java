package com.httd.api.business.home.service;

import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeBannerListDTO;
import com.httd.api.mapper.po.HomeBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页轮播图 服务类
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
public interface IHomeBannerService extends IService<HomeBanner> {

    /**
     * 获取首页轮播图列表
     *
     * @param vo
     * @return
     */
    List<FindHomeBannerListDTO> findHomeBannerList(BaseVO vo) throws Exception;
}
