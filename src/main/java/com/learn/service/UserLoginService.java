package com.learn.service;

import com.learn.entity.UserLogin;

public interface UserLoginService {
    UserLogin findByUserName(String userName);
}
