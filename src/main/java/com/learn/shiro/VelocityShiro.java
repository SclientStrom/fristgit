package com.learn.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocityShiro {
    private static final Logger logger= LoggerFactory.getLogger(VelocityShiro.class);

    public boolean hasPermission(String permission){
        logger.info(permission);
        Subject subject= SecurityUtils.getSubject();
        return subject!=null && subject.isPermitted(permission);
    }
}
