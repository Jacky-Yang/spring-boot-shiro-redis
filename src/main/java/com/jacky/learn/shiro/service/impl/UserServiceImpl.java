package com.jacky.learn.shiro.service.impl;

import com.jacky.learn.shiro.dao.UserDao;
import com.jacky.learn.shiro.entity.User;
import com.jacky.learn.shiro.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractCommonEntityService<User> implements IUserService {

    public UserServiceImpl(UserDao userDao) {
        super(userDao);
    }
}
