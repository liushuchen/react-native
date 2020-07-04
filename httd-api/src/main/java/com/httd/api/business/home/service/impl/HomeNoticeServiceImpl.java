package com.httd.api.business.home.service.impl;

import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeNoticeListDTO;
import com.httd.api.mapper.po.HomeNotice;
import com.httd.api.mapper.HomeNoticeMapper;
import com.httd.api.business.home.service.IHomeNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页公告 服务实现类
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@Service
public class HomeNoticeServiceImpl extends ServiceImpl<HomeNoticeMapper, HomeNotice> implements IHomeNoticeService {

    private final HomeNoticeMapper homeNoticeMapper;

    public HomeNoticeServiceImpl(HomeNoticeMapper homeNoticeMapper) {
        this.homeNoticeMapper = homeNoticeMapper;
    }

    /**
     * 获取首页公告
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @Override
    public List<FindHomeNoticeListDTO> findHomeNoticeList(BaseVO vo) throws Exception {
        return homeNoticeMapper.findHomeNoticeList(vo);
    }
}
