package com.httd.api.business.config.controller;

import com.httd.api.business.config.entity.*;
import com.httd.api.business.config.service.IConfigService;
import com.httd.api.base.BaseController;
import com.httd.api.base.BaseParam;
import com.httd.api.base.BaseResult;
import com.httd.api.base.BaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "config")
public class ConfigController extends BaseController {
    private final IConfigService configService;

    @Autowired
    public ConfigController(IConfigService configService) {
        this.configService = configService;
    }

    /**
     * 获取短信验证码
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findSmsCode")
    public BaseResult findDeviceByUserId(@RequestBody @Validated FindSmsCodeVO vo) throws Exception {
        String result = configService.findSmsCode(vo);
        return responseSuccess(result);
    }

    /**
     * 获取协议列表
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @BaseParam
    @RequestMapping(value = "findAgreement")
    public BaseResult findAgreement(@RequestBody @Validated FindAgreementVO vo) throws Exception {
        FindAgreementDTO dto = configService.findAgreement(vo);
        return responseSuccess(dto);
    }

    /**
     * 获取版本控制
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @BaseParam
    @RequestMapping(value = "findAppVersion")
    public BaseResult findAppVersion(@RequestBody @Validated BaseVO vo) throws Exception {
        FindAppVersionDTO result = configService.findAppVersion(vo);
        return responseSuccess(result);
    }

    /**
     * 获取关于页面
     *
     * @param vo
     * @return
     * @throws Exception
     */
    @BaseParam
    @RequestMapping(value = "findAppAbout")
    public BaseResult findAppAbout(@RequestBody @Validated BaseVO vo) throws Exception {
        FindAppAboutDTO result = configService.findAppAbout(vo);
        return responseSuccess(result);
    }
}
