package com.httd.api.business.config.service;

import com.httd.api.business.config.entity.*;
import com.httd.api.base.BaseVO;

public interface IConfigService {
    /**
     * 发送短信验证吗
     *
     * @param vo
     */
    String findSmsCode(FindSmsCodeVO vo) throws Exception;

    /**
     * 获取协议数据
     *
     * @param vo
     * @return
     */
    FindAgreementDTO findAgreement(FindAgreementVO vo);

    /**
     * 获取版本控制
     *
     * @param vo
     * @return
     */
    FindAppVersionDTO findAppVersion(BaseVO vo);

    /**
     * 获取关于页面数据
     *
     * @param vo
     * @return
     */
    FindAppAboutDTO findAppAbout(BaseVO vo);

    /**
     * 修改协议
     *
     * @param vo
     */
    void updateAgreement(UpdateAgreementVO vo);

    /**
     * 修改APP版本信息
     *
     * @param vo
     */
    void updateAppVersion(UpdateAppVersionVO vo);

    /**
     * 修改关于数据
     *
     * @param vo
     */
    void updateAppAbout(UpdateAppAboutVO vo);

    /**
     * 添加协议
     *
     * @param vo
     */
    void saveAgreement(SaveAgreementVO vo);
}
