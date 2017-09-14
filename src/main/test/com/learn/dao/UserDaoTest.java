package com.learn.dao;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.learn.entity.UserLogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/context/context.xml","/context/context-*.xml"})
public class UserDaoTest {
    private static  final Logger logger= LoggerFactory.getLogger(UserDaoTest.class);
    @Autowired
    private  UserDao userDao;
    @Test
    public void getUser() throws Exception {
        System.out.println(userDao.getUser(2));
    }

    @Test
    public void getUsers() throws Exception {
        UserLogin res = userDao.findByUserName("slient");
        logger.info("user Res: {}", JSON.toJSONString(res));
        Gson gson=new Gson();
        logger.info("user Gson res:{}", gson.toJson(res));
    }
}