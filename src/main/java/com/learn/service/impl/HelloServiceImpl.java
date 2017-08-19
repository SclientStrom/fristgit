package com.learn.service.impl;

import com.learn.service.HelloService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2017/8/18.
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService{
    public String getHelloMessage(String name) throws  Exception {
        return name;
    }
}
