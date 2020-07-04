package com.httd.api.business.home.service;

import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeMenuListDTO;
import com.httd.api.mapper.po.HomeMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页菜单 服务类
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
public interface IHomeMenuService extends IService<HomeMenu> {

    /**
     * 获取首页菜单列表
     * @param vo
     * @return
     */
    List<FindHomeMenuListDTO> findHomeMenuList(BaseVO vo) throws Exception;
}
