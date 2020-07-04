package com.httd.api.business.home.service;

import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeNoticeListDTO;
import com.httd.api.mapper.po.HomeNotice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页公告 服务类
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
public interface IHomeNoticeService extends IService<HomeNotice> {

    /**
     * 获取首页公告
     *
     * @param vo
     * @return
     */
    List<FindHomeNoticeListDTO> findHomeNoticeList(BaseVO vo) throws Exception;
}
