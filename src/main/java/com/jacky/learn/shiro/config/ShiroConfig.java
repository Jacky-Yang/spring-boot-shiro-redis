package com.jacky.learn.shiro.config;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ShiroConfig {

    private ShiroService shiroService;

    public ShiroConfig(ShiroService shiroService) {
        this.shiroService = shiroService;
    }

    @Bean
    protected ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        System.out.println("SecurityManager:" + securityManager);
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();

        filterFactoryBean.setSecurityManager(securityManager);
        filterFactoryBean.setLoginUrl("/login.html");
        filterFactoryBean.setFilterChainDefinitionMap(shiroService.loadFilterChainDefinitions());

        return filterFactoryBean;
    }

    /**
     * 配置 SecurityManager Bean
     * SecurityManager 继承了SessionManager接口，但是具体实现委托给了具体的SessionManager的实现类
     * @return SecurityManager
     */
    @Bean
    public SecurityManager securityManager() {
        // 由于是Web项目，所以使用Web安全管理器，
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        System.out.println("securityManager:" + securityManager);
        securityManager.setRealm(realm());

        securityManager.setCacheManager(cacheManager());
        securityManager.setSessionManager(sessionManager());
        return  securityManager;
    }

    @Bean
    public Realm realm() {
        System.out.println("authorizingRealm");
        return new UserRealm();
    }

    /**
     * 配置redis缓存管理器
     * @return CacheManager
     */
    @Bean
    protected CacheManager cacheManager() {
        RedisCacheManager cacheManager  = new RedisCacheManager();
        cacheManager.setRedisManager(redisManager());
        System.out.println("cacheManager:" + cacheManager);
        return cacheManager;
    }

    @Bean
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        System.out.println("sessionManager:" + sessionManager);
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }

    @Bean
    public SessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        System.out.println("redisSessionDAO:" + redisSessionDAO);
        return redisSessionDAO;
    }

    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("127.0.0.1:6379");
        // 配置过期时间
//        redisManager.setExpire(1800);
        redisManager.setTimeout(5000);
//        redisManager.setPassword(redisConfig.getPassword());

        System.out.println("redisManager:"+ redisManager);

        return redisManager;
    }
}
