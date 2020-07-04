package com.httd.api.business.user.service.impl;

import com.httd.api.mapper.po.UserAccount;
import com.httd.api.mapper.UserAccountMapper;
import com.httd.api.business.user.service.IUserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账号信息 服务实现类
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService {

}
