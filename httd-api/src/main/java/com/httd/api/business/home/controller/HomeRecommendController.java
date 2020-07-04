package com.httd.api.business.home.controller;


import com.httd.api.base.BaseController;
import com.httd.api.base.BaseParam;
import com.httd.api.base.BaseResult;
import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeRecommendListDTO;
import com.httd.api.business.home.service.IHomeRecommendService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页推荐 前端控制器
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-27
 */
@RestController
@RequestMapping("homeRecommend")
public class HomeRecommendController extends BaseController {
    private final IHomeRecommendService homeRecommendService;

    public HomeRecommendController(IHomeRecommendService homeRecommendService) {
        this.homeRecommendService = homeRecommendService;
    }

    /**
     * 获取首页推荐
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @BaseParam
    @RequestMapping(value = "findHomeRecommendList")
    public BaseResult findHomeRecommendList(@RequestBody @Validated BaseVO vo) throws Exception {
        List<FindHomeRecommendListDTO> list = homeRecommendService.findHomeRecommendList(vo);
        return responseSuccess(list);
    }
}

