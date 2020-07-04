package com.httd.api.business.user.service.impl;

import com.httd.api.mapper.po.UserInfo;
import com.httd.api.mapper.UserInfoMapper;
import com.httd.api.business.user.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户列表 服务实现类
 * </p>
 *
 * @author w_liusc
 * @since 2020-06-25
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
