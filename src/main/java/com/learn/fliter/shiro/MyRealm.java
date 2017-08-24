package com.learn.fliter.shiro;

import com.learn.dao.UserLoginDao;
import com.learn.entity.LoginRole;
import com.learn.entity.LoginUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesJava8;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ThinkPad on 2017/8/24.
 */
public class MyRealm extends AuthorizingRealm{
    @Autowired
    private UserLoginDao userLoginDao;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        LoginUser user = (LoginUser) principal.fromRealm(getName()).iterator().next();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        List<String> roles = user.getRoles().stream().map(LoginRole::getRoleName).distinct().collect(Collectors.<String>toList());
        info.addRoles(roles);
        return info;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken= (UsernamePasswordToken) token;
        LoginUser user=userLoginDao.getByUserName(userToken.getUsername());
        if(user==null){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
