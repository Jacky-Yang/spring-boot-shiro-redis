package com.jacky.learn.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {

//    private static final String loginUrl = "login.html";
//
//    @Autowired
//    protected SecurityManager securityManager;
//
//    @Autowired
//    protected ShiroFilterChainDefinition shiroFilterChainDefinition;
//
//    @Bean
//    protected ShiroFilterFactoryBean shiroFilterFactoryBean() {
//        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
//
//        filterFactoryBean.setLoginUrl(loginUrl);
////        filterFactoryBean.setSuccessUrl(successUrl);
////        filterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);
////
//        filterFactoryBean.setSecurityManager(securityManager);
//        filterFactoryBean.setFilterChainDefinitionMap(shiroFilterChainDefinition.getFilterChainMap());
//
//        return filterFactoryBean;
//    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/login.html", "anon");
        chainDefinition.addPathDefinition("/**", "authc");
        return chainDefinition;
    }

    @Bean
    public Realm authorizingRealm() {
        return new UserRealm();
    }
}
