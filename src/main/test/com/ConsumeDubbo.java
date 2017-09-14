package com;

import com.learn.service.DubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumeDubbo {
    public static void main(String []args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"/context/consume-dubbo.xml"});
        context.start();
        DubboService demoService = (DubboService) context.getBean("demo"); // obtain proxy object for remote invocation
        String hello = demoService.sayHello("world"); // execute remote invocation
        System.out.println(hello); // show the result
    }
}
