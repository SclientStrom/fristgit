package com.learn.entity;

import java.util.List;

/**
 * Created by ThinkPad on 2017/8/24.
 */
public class LoginRole {
    private String roleName;
    private List<LoginPermission> permissions;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<LoginPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<LoginPermission> permissions) {
        this.permissions = permissions;
    }
}
