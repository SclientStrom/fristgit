package com.learn.controller.res;

import com.learn.entity.User;

import java.util.List;

public class UserRes {
    List<User> users;


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserRes{" +
                "users=" + users +
                '}';
    }
}
