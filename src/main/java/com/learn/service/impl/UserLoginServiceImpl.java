package com.learn.service.impl;

import com.learn.dao.UserDao;
import com.learn.entity.UserLogin;
import com.learn.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserDao userDao;
    public UserLogin findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
