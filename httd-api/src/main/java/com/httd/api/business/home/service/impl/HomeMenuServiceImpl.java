package com.httd.api.business.home.service.impl;

import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeMenuListDTO;
import com.httd.api.mapper.po.HomeMenu;
import com.httd.api.mapper.HomeMenuMapper;
import com.httd.api.business.home.service.IHomeMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页菜单 服务实现类
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@Service
public class HomeMenuServiceImpl extends ServiceImpl<HomeMenuMapper, HomeMenu> implements IHomeMenuService {

    private final HomeMenuMapper homeMenuMapper;

    public HomeMenuServiceImpl(HomeMenuMapper homeMenuMapper) {
        this.homeMenuMapper = homeMenuMapper;
    }

    /**
     * 获取首页菜单
     * @param vo
     * @return
     * @throws Exception
     */
    @Override
    public List<FindHomeMenuListDTO> findHomeMenuList(BaseVO vo) throws Exception {
        return homeMenuMapper.findHomeMenuList(vo);
    }
}
