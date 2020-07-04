package com.httd.api.business.home.controller;


import com.httd.api.base.BaseController;
import com.httd.api.base.BaseParam;
import com.httd.api.base.BaseResult;
import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeMenuListDTO;
import com.httd.api.business.home.service.IHomeMenuService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页菜单 前端控制器
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@RestController
@RequestMapping("homeMenu")
public class HomeMenuController extends BaseController {
    private final IHomeMenuService homeMenuService;


    public HomeMenuController(IHomeMenuService homeMenuService) {
        this.homeMenuService = homeMenuService;
    }

    /**
     * 获取首页轮播图
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @BaseParam
    @RequestMapping(value = "findHomeMenuList")
    public BaseResult findHomeMenuList(@RequestBody @Validated BaseVO vo) throws Exception {
        List<FindHomeMenuListDTO> list = homeMenuService.findHomeMenuList(vo);
        return responseSuccess(list);
    }
}

