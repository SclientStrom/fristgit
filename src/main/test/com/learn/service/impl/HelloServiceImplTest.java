package com.learn.service.impl;

import com.learn.service.HelloService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ThinkPad on 2017/8/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context/context.xml" ,"classpath:context/context-servlet.xml"})
public class HelloServiceImplTest {
    @Autowired
    private HelloService helloService;
    @org.junit.Test
    public void getHelloMessage() throws Exception {
        helloService.getHelloMessage("ceshi");
    }

}