package com.learn.service.impl;

import com.learn.service.DubboService;

public class DubboServiceImpl implements DubboService {
    public String sayHello(String name) {
        return "hello " +name;
    }
}
