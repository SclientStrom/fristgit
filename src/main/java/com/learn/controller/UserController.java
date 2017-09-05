package com.learn.controller;
import com.learn.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("success.htm")
    public String homeView(){
        return "success";
    }

    @RequestMapping("index.json")
    @ResponseBody
    public User getUser(){
        User user=new User();
        user.setName("小米");
        user.setAge(5);
        return user;
    }
    @RequestMapping("searchAllUser.json")
    @ResponseBody
    public List<User> searchAllUser(){
        List<User> users=new ArrayList<User>();
        User user=new User();
        user.setAge(5);
        user.setName("小米");
        users.add(user);
        User user1=new User();
        user1.setName("京东");
        user.setAge(9);
        users.add(user1);
        return users;
    }
}
