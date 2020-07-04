package com.httd.api.business.home.service.impl;

import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeBannerListDTO;
import com.httd.api.mapper.po.HomeBanner;
import com.httd.api.mapper.HomeBannerMapper;
import com.httd.api.business.home.service.IHomeBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页轮播图 服务实现类
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@Service
public class HomeBannerServiceImpl extends ServiceImpl<HomeBannerMapper, HomeBanner> implements IHomeBannerService {

    private final HomeBannerMapper homeBannerMapper;

    public HomeBannerServiceImpl(HomeBannerMapper homeBannerMapper) {
        this.homeBannerMapper = homeBannerMapper;
    }

    /**
     * 获取首页轮播图
     * @param vo
     * @return
     * @throws Exception
     */
    @Override
    public List<FindHomeBannerListDTO> findHomeBannerList(BaseVO vo) throws Exception {
        return homeBannerMapper.findHomeBannerList(vo);
    }
}
