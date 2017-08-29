package com.learn.shiro;

import com.learn.entity.Role;
import com.learn.entity.User;
import com.learn.entity.UserLogin;
import com.learn.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class ShiroDbRealm extends AuthorizingRealm {
    @Autowired
    private UserLoginService userLoginService;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        UserLogin user= (UserLogin) principal.fromRealm(this.getClass().getName()).iterator().next();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        List<Role>roles=user.getRoles();
        roles.stream().map(Role :: getRname);
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken passwordToken= (UsernamePasswordToken) authenticationToken;
        String userName=passwordToken.getUsername();
        UserLogin user=userLoginService.findByUserName(userName);
        if(user==null){
            return null;
        }else{
            return new SimpleAuthenticationInfo(user,user.getPassWord(),this.getClass().getName());
        }
    }
}
