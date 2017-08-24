package com.learn.entity;

import java.util.List;

/**
 * Created by ThinkPad on 2017/8/24.
 */
public class LoginUser {
    private String username;
    private String password;
    private List<LoginRole> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<LoginRole> getRoles() {
        return roles;
    }

    public void setRoles(List<LoginRole> roles) {
        this.roles = roles;
    }
}
