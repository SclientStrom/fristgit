package com.learn.controller;

import com.learn.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;

/**
 * Created by ThinkPad on 2017/8/18.
 */
@Controller
public class AopController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("aop.htm")
    @ResponseBody
    public String getName(@WebParam(name = "name") String name) throws Exception {
        return  helloService.getHelloMessage(name);
    }
}
