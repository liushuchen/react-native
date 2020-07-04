package com.httd.api.business.home.controller;


import com.httd.api.base.BaseController;
import com.httd.api.base.BaseParam;
import com.httd.api.base.BaseResult;
import com.httd.api.base.BaseVO;
import com.httd.api.business.home.entity.FindHomeNoticeListDTO;
import com.httd.api.business.home.service.IHomeNoticeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页公告 前端控制器
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@RestController
@RequestMapping("homeNotice")
public class HomeNoticeController extends BaseController {

    private final IHomeNoticeService homeNoticeService;

    public HomeNoticeController(IHomeNoticeService homeNoticeService) {
        this.homeNoticeService = homeNoticeService;
    }

    /**
     * 获取首页轮播图
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @BaseParam
    @RequestMapping(value = "findHomeNoticeList")
    public BaseResult findHomeNoticeList(@RequestBody @Validated BaseVO vo) throws Exception {
        List<FindHomeNoticeListDTO> list = homeNoticeService.findHomeNoticeList(vo);
        return responseSuccess(list);
    }
}

