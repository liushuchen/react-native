package com.httd.api.business.home.controller;


import com.httd.api.base.BaseController;
import com.httd.api.base.BaseParam;
import com.httd.api.base.BaseResult;
import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeBannerListDTO;
import com.httd.api.business.home.service.IHomeBannerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页轮播图 前端控制器
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@RestController
@RequestMapping("homeBanner")
public class HomeBannerController extends BaseController {

    private final IHomeBannerService homeBannerService;


    public HomeBannerController(IHomeBannerService homeBannerService) {
        this.homeBannerService = homeBannerService;
    }

    /**
     * 获取首页轮播图
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @BaseParam
    @RequestMapping(value = "findHomeBannerList")
    public BaseResult findHomeBannerList(@RequestBody @Validated BaseVO vo) throws Exception {
        List<FindHomeBannerListDTO> list = homeBannerService.findHomeBannerList(vo);
        return responseSuccess(list);
    }
}

