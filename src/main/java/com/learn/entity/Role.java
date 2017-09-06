package com.learn.entity;

import java.util.List;

public class Role {
    private String rname;
    private List<UserModule> modules;

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public List<UserModule> getModules() {
        return modules;
    }

    public void setModules(List<UserModule> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rname='" + rname + '\'' +
                ", modules=" + modules +
                '}';
    }
}
