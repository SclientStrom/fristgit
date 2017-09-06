package com.learn.controller;

import com.learn.entity.UserLogin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping("index.htm")
    public ModelAndView loginError(HttpServletRequest request){
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        ModelAndView view=new ModelAndView("login");
        if(inputFlashMap!=null){
            view.addObject("msg","loginError");
        }
        return view;
    }
    @RequestMapping("login.htm")
    public String loginUser(String username, String password, HttpSession session, RedirectAttributes attr) {
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            UserLogin user=(UserLogin) subject.getPrincipal();
            session.setAttribute("user", user);
            return "success";
        } catch(Exception e) {
            attr.addFlashAttribute("error","loginError");
            return "redirect:index.htm";//返回登录页面
        }
    }
}
