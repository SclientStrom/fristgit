package com.learn.entity;

public class UserModule {
    @Override
    public String toString() {
        return "UserModule{" +
                "mName='" + mName + '\'' +
                '}';
    }

    private String mName;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

}
