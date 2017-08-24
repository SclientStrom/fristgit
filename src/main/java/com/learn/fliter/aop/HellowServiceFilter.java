package com.learn.fliter.aop;

import org.aspectj.lang.ProceedingJoinPoint;

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
