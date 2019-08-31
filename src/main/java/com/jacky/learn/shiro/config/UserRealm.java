package com.jacky.learn.shiro.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);

    /**
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        AuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        LOGGER.debug("doGetAuthorizationInfo");
        return authorizationInfo;
    }

    /**
     * 获取认证信息
     * @param token
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = token.getPrincipal().toString();
        String pwd = token.getCredentials().toString();
        System.out.println(pwd);
        String password = new String((char[]) token.getCredentials());
        if (!"admin".equals(name) || !"admin".equals(password)) {
            throw new UnknownAccountException();
        }
        String realmName = getName();
        System.out.println("realmName:" + realmName);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(name, password, realmName);
        return authenticationInfo;
    }
}
