package com.httd.api.business.config.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.httd.api.business.config.entity.*;
import com.httd.api.business.config.service.IConfigService;
import com.httd.api.business.redis.IRedisService;
import com.httd.api.base.BaseException;
import com.httd.api.base.BaseVO;
import com.httd.api.enums.CodeTypeEnum;
import com.httd.api.mapper.AgreementMapper;
import com.httd.api.mapper.AppAboutMapper;
import com.httd.api.mapper.AppVersionMapper;
import com.httd.api.mapper.po.Agreement;
import com.httd.api.mapper.po.AppAbout;
import com.httd.api.mapper.po.AppVersion;
import com.httd.api.utils.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConfigServiceImpl implements IConfigService {

    private final IRedisService redisService;

    private final AppAboutMapper appAboutMapper;

    private final AppVersionMapper appVersionMapper;

    private final AgreementMapper agreementMapper;

    @Autowired
    public ConfigServiceImpl(IRedisService redisService, AppAboutMapper appAboutMapper, AppVersionMapper appVersionMapper, AgreementMapper agreementMapper) {
        this.redisService = redisService;
        this.appAboutMapper = appAboutMapper;
        this.appVersionMapper = appVersionMapper;
        this.agreementMapper = agreementMapper;
    }

    /**
     * 发送短信验证吗
     *
     * @param vo
     */
    @Override
    public String findSmsCode(FindSmsCodeVO vo) throws Exception {
        //1,查询这个手机号的验证吗是否过期
        boolean check = redisService.smsCodeExists(vo.getCodeType(), vo.getPhone());
        if (check)
            throw new BaseException("原来的密码还有效,请勿重复获取");
        //2.生成短信验证码
        String smsCode = RandomUtil.randomNumbers(6);
        log.info("向手机{},发送短信验证码{}", vo.getPhone(), smsCode);
        //3.发送短信
        String template = StrUtil.format("您好，您的验证码是{}，请在5分钟内完成验证。【艾菲尼智能】", smsCode);
        boolean sendStatus = SmsUtil.sendSms(vo.getPhone(), template);
        if (!sendStatus)
            throw new BaseException("短信发送失败,请稍后再试");
        //4.将验证码存入缓存
        redisService.updateSmsCode(CodeTypeEnum.RESET_PWD.getCode(), vo.getPhone(), smsCode);
        return "短信发送成功";
    }

    /**
     * 获取协议
     *
     * @param vo
     * @return
     */
    @Override
    public  FindAgreementDTO findAgreement(FindAgreementVO vo) {
        return agreementMapper.findAgreement(vo.getType());
    }

    /**
     * 获取APP配置
     *
     * @param vo
     * @return
     */
    @Override
    public FindAppVersionDTO findAppVersion(BaseVO vo) {
        FindAppVersionDTO dto =new FindAppVersionDTO();
        AppVersion appVersion = appVersionMapper.selectById(1);
        BeanUtil.copyProperties(appVersion,dto);
        return dto;
    }

    /**
     * 获取关于页面数据
     *
     * @param vo
     * @return
     */
    @Override
    public FindAppAboutDTO findAppAbout(BaseVO vo) {
        FindAppAboutDTO dto =new FindAppAboutDTO();
        AppAbout appAbout = appAboutMapper.selectById(1);
        BeanUtil.copyProperties(appAbout,dto);
        return dto;
    }

    /**
     * 修改协议内容
     *
     * @param vo
     */
    @Override
    public void updateAgreement(UpdateAgreementVO vo) {
        agreementMapper.updateAgreement(vo);
    }

    /**
     * 修改版本信息
     *
     * @param vo
     */
    @Override
    public void updateAppVersion(UpdateAppVersionVO vo) {
        AppVersion update = new AppVersion();
        BeanUtil.copyProperties(vo,update);
        update.setVersionId(1);
        appVersionMapper.updateById(update);
    }

    /**
     * 修改关于页面数据
     *
     * @param vo
     */
    @Override
    public void updateAppAbout(UpdateAppAboutVO vo) {
        AppAbout update = new AppAbout();
        BeanUtil.copyProperties(vo,update);
        appAboutMapper.updateById(update);
    }

    /**
     * 添加协议
     */
    @Override
    public void saveAgreement(SaveAgreementVO vo) {
        Agreement save = new Agreement();
        save.setContent(vo.getContent());
        save.setType(vo.getType());
        agreementMapper.insert(save);
    }
}
