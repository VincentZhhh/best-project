package com.zhangweisen.best.project.user.service.impl;

import com.zhangweisen.best.project.user.entity.User;
import com.zhangweisen.best.project.user.mapper.UserMapper;
import com.zhangweisen.best.project.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author zhangweisen
 * @since 2025-02-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
