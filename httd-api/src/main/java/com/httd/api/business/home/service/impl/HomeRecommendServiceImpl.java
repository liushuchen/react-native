package com.httd.api.business.home.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeRecommendListDTO;
import com.httd.api.business.home.service.IHomeRecommendService;
import com.httd.api.mapper.HomeRecommendMapper;
import com.httd.api.mapper.po.HomeRecommend;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页推荐 服务实现类
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-27
 */
@Service
public class HomeRecommendServiceImpl extends ServiceImpl<HomeRecommendMapper, HomeRecommend> implements IHomeRecommendService {
    private final HomeRecommendMapper homeRecommendMapper;

    public HomeRecommendServiceImpl(HomeRecommendMapper homeRecommendMapper) {
        this.homeRecommendMapper = homeRecommendMapper;
    }
    /**
     * 获取首页推荐列表
     * @param vo
     * @return
     * @throws Exception
     */
    @Override
    public List<FindHomeRecommendListDTO> findHomeRecommendList(BaseVO vo) throws Exception {
        return homeRecommendMapper.findHomeRecommendList(vo);
    }
}
