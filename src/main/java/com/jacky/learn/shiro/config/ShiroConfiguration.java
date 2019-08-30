package com.jacky.learn.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.config.web.autoconfigure.ShiroWebAutoConfiguration;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@AutoConfigureBefore(ShiroWebAutoConfiguration.class)
public class ShiroConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfiguration.class);

    private ShiroProperties shiroProperties;

    private ShiroService shiroService;

    public ShiroConfiguration(ShiroProperties shiroProperties, ShiroService shiroService) {
        this.shiroProperties = shiroProperties;
        this.shiroService = shiroService;
    }

//    @Bean
//    protected ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
//        System.out.println("SecurityManager:" + securityManager);
//        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
//
//        filterFactoryBean.setSecurityManager(securityManager);
//        filterFactoryBean.setFilterChainDefinitionMap(shiroService.loadFilterChainDefinitions());
//
//        return filterFactoryBean;
//    }

    /**
     * 配置 SecurityManager Bean
     * SecurityManager 继承了SessionManager接口，但是具体实现委托给了具体的SessionManager的实现类
     * @return SecurityManager
     */
//    @Bean
//    public SecurityManager securityManager() {
//        // 由于是Web项目，所以使用Web安全管理器，
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(authorizingRealm());
//
//        securityManager.setSessionManager(sessionManager());
//        return  securityManager;
//    }

    @Bean
    public Realm authorizingRealm() {
        System.out.println("authorizingRealm");
        return new UserRealm();
    }

//    @Bean
//    public SessionManager sessionManager() {
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
////        sessionManager.setSessionDAO();
//        return sessionManager;
//    }

    // temp code TODO delete
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        LOGGER.info("shiroFilterChainDefinition");
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/login.html", "anon");
        chainDefinition.addPathDefinition("/login", "anon");
        chainDefinition.addPathDefinition("/**", "authc");
        return chainDefinition;
    }
}
