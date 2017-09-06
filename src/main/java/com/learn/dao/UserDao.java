package com.learn.dao;

import com.learn.entity.User;
import com.learn.entity.UserLogin;

/**
 * @// TODO: 2017/9/6 the class deal with user's permission.
 */
public interface UserDao {
    /**
     * 根据用户的id查询用户的信息
     * @param id
     * @return
     */
    UserLogin getUser(int id);

    /**
     * 根据用户的账号查询用户信息
     * @param username
     * @return
     */
    UserLogin findByUserName(String username);

}
