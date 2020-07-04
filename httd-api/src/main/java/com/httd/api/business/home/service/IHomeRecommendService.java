package com.httd.api.business.home.service;

import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeRecommendListDTO;
import com.httd.api.mapper.po.HomeRecommend;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页推荐 服务类
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-27
 */
public interface IHomeRecommendService extends IService<HomeRecommend> {

    /**
     * 获取首页推荐
     * @param vo
     * @return
     */
    List<FindHomeRecommendListDTO> findHomeRecommendList(BaseVO vo) throws  Exception;
}
