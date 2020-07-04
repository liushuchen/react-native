package com.httd.api.business.redis;

public interface IRedisService {
    /**
     * 校验短信验证吗是否有效
     * @param codeType
     * @param phone
     * @return
     */
    boolean smsCodeExists(Integer codeType, String phone)  throws  Exception;

    /**
     * 检验短信验证码是否正确
     * @param codeType
     * @param phone
     * @param smsCode
     * @return
     * @throws Exception
     */
    boolean smsCodeCheck(Integer codeType, String phone,String smsCode)  throws  Exception;

    /**
     * 储存短信验证码
     * @param codeType
     * @param phone
     * @throws Exception
     */
    void updateSmsCode(Integer codeType, String phone,String smsCode)  throws  Exception;

    /**
     * 生成登录tokoen
     * @param adminId
     * @return
     */
    String createToken(Long adminId) throws  Exception;

    /**
     * 退出登录清空token
     * @param adminId
     * @throws Exception
     */
    void delToken(Long adminId) throws  Exception;

    /**
     * 根据token获取用户id
     * @param token
     * @return
     */
    Long findAdminIdByToken(String token) throws  Exception;

    /**
     * 修改用户状态退出登录
     * @param userId
     */
    void updateUserStateByUserId(String userId);
}
