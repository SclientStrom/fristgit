package com.learn.dao;

import com.learn.entity.LoginUser;

/**
 * Created by ThinkPad on 2017/8/24.
 */
public interface UserLoginDao {
    public LoginUser getByUserName(String username);
}
