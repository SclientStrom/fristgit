package com.learn.dao;

import com.learn.entity.User;

public interface UserDao {
    User getStudentByname(String name);
}
