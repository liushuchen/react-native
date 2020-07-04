package com.httd.api.mapper;

import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeNoticeListDTO;
import com.httd.api.mapper.po.HomeNotice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 首页公告 Mapper 接口
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
public interface HomeNoticeMapper extends BaseMapper<HomeNotice> {

    /**
     * 获取首页公告
     * @return
     */
    List<FindHomeNoticeListDTO> findHomeNoticeList(BaseVO vo)throws Exception;
}
