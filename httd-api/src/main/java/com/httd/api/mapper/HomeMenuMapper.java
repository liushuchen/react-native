package com.httd.api.mapper;

import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeMenuListDTO;
import com.httd.api.mapper.po.HomeMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 首页菜单 Mapper 接口
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
public interface HomeMenuMapper extends BaseMapper<HomeMenu> {

    /**
     * 获取首页菜单
     * @return
     */
    List<FindHomeMenuListDTO> findHomeMenuList(BaseVO vo) throws Exception;
}
