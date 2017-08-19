package com.learn.service;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by ThinkPad on 2017/8/18.
 */
public interface HelloService {

    String getHelloMessage(String name ) throws Exception;
}
