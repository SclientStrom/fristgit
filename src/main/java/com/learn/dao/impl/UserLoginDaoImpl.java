package com.learn.dao.impl;

import com.learn.dao.UserLoginDao;
import com.learn.entity.LoginUser;
import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2017/8/24.
 */
@Component
public class UserLoginDaoImpl implements UserLoginDao {
    public LoginUser getByUserName(String username) {
        return null;
    }
}
