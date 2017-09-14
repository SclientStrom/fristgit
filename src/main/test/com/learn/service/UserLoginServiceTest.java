package com.learn.service;

import com.alibaba.fastjson.JSON;
import com.learn.dao.UserDao;
import com.learn.entity.UserLogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/context/context.xml","/context/context-*.xml"})
public class UserLoginServiceTest {
    private static final Logger logger= LoggerFactory.getLogger(UserLoginServiceTest.class);
    @Autowired
    private UserLoginService userLoginService;
    @Test
    public void findByUserName() throws Exception {
        UserLogin res = userLoginService.findByUserName("slient");
        logger.info("userRoleAndPerMission res: {}", JSON.toJSONString(res));
    }
}