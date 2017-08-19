package com.learn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2017/8/18.
 */
public class HellowServiceFilter {

    public Object filter(ProceedingJoinPoint point) throws Throwable {
        Object [] objs=point.getArgs();
        objs[0]="name";
        System.out.println(System.currentTimeMillis());
        return point.proceed(objs);
    }
}
