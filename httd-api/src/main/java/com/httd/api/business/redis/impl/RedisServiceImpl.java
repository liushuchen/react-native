package com.httd.api.business.redis.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.httd.api.business.redis.IRedisService;
import com.httd.api.base.BaseException;
import com.httd.api.base.RedisKeys;
import com.httd.api.enums.ResultEnum;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements IRedisService {

    private final RedisTemplate redisTemplate;

    public RedisServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 生成登录token
     *
     * @param userId
     * @return
     */
    @Override
    public String createToken(Long userId) {
        // 先删除旧的token
        delToken(userId);
        // 创建新的token
        long seconds = 2592000 * 12 * 10;// 秒 保存有效期一个月*12*10
        String token = IdUtil.fastSimpleUUID();
        String userToken = RedisKeys.AdminToken(SecureUtil.md5(userId + ""));
        setValue(RedisKeys.AdminToken(token), userId, seconds);
        setValue(userToken, RedisKeys.AdminToken(token), seconds);
        return token;
    }

    /**
     * 删除token
     *
     * @param userId
     * @return userid
     */
    @Override
    public void delToken(Long userId) {
        //获取对应的token值
        String userToken = RedisKeys.AdminToken(SecureUtil.md5(userId + ""));
        Object str = getValue(userToken);
        if (str != null) {
            remove(str.toString());
            remove(userToken);
        }
    }

    @Override
    public Long findAdminIdByToken(String token) throws Exception {
        //获取对应的token值
        String userToken = RedisKeys.AdminToken(token);
        Object adminId = getValue(userToken);
        if (adminId == null)
            throw new BaseException(ResultEnum.TOKEN_ERROR);
        return (long) adminId;
    }

    /**
     * 修改APP用户状态 退出登录
     *
     * @param userId
     */
    @Override
    public void updateUserStateByUserId(String userId) {
        String userToken = RedisKeys.AppToken(SecureUtil.md5(userId));
        Object str = getValue(userToken);
        if (str != null) {
            remove(str.toString());
            remove(userToken);
        }
    }

    /**
     * 删除缓存的数据
     *
     * @param key
     */
    public void remove(final String key) {
        redisTemplate.delete(key);
    }

    /**
     * 数据是否存在
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 储存数据
     *
     * @param key(储存的key)
     * @param value(值)
     * @param time(秒)
     * @return
     */
    private boolean setValue(String key, Object value, Long time) {
        try {
            if (time == null || time < 1) {
                redisTemplate.opsForValue().set(key, value);//永久储存
            } else {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 永久储存数据
     *
     * @param key(储存的key)
     * @param value(值)
     * @return
     */
    private boolean setValue(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取缓存的数据
     *
     * @param key
     * @return
     */
    private Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 校验短信验证码是否有效
     *
     * @param codeType
     * @param phone
     * @return
     */
    @Override
    public boolean smsCodeExists(Integer codeType, String phone) throws Exception {
        return exists(RedisKeys.SmsCode(codeType, phone));
    }

    /**
     * 校验短信验证码是否正确
     *
     * @param codeType
     * @param phone
     * @return
     */
    @Override
    public boolean smsCodeCheck(Integer codeType, String phone, String smsCode) throws Exception {
        smsCodeExists(codeType, phone);
        Object value = getValue(RedisKeys.SmsCode(codeType, phone));
        if (smsCode.equals(value == null ? "" : value.toString()))
            return true;
        return false;
    }

    /**
     * 更新短信验证码
     *
     * @param codeType
     * @param phone
     * @throws Exception
     */
    @Override
    public void updateSmsCode(Integer codeType, String phone, String smsCode) throws Exception {
        setValue(RedisKeys.SmsCode(codeType, phone), smsCode, 300l);
    }

}
