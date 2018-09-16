package com.cyh.ums.config;

import com.cyh.ums.shiro.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.Filter;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 1.配置shiro拦截器
     * 2.自定义认证、授权器
     * 3.配置reaml领域
     * 4.配置安全管理器
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        System.out.println("配置shiro拦截器ShiroConfiguration.shirFilter()");

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        Map<String, Filter> filterBean=shiroFilterFactoryBean.getFilters();
        UserLoginFilter userLoginFilter = new UserLoginFilter();
 /*       userLoginFilter.setUsernameParam("username");
        userLoginFilter.setPasswordParam("password");*/
        filterBean.put("authc",userLoginFilter);
        shiroFilterFactoryBean.setFilters(filterBean);

        shiroFilterFactoryBean.setLoginUrl("/ums/html/user/login/login.html");
        shiroFilterFactoryBean.setSuccessUrl("/ums/html/user/login/index.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("403.html");
        //对不同文件统一配置拦截类型
        Map<String, String> filterMap =shiroFilterFactoryBean.getFilterChainDefinitionMap();
        filterMap.put("/ums/css/**", "anon");
        filterMap.put("/ums/js/**", "anon");
        filterMap.put("/ums/img/**", "anon");
        filterMap.put("/ums/user/login", "anon");
        filterMap.put("/ums/lookup/lookup", "anon");
        filterMap.put("/ums/languageCode/i18n", "anon");
        filterMap.put("/**", "authc");
        //设置权限管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SessionsSecurityManager securityManager(RedisCacheManager redisCacheManager){
        DefaultWebSecurityManager defaultSecurityManager=new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(passwordReaml(redisCacheManager));
        return defaultSecurityManager;
    }

    @Bean
    public PasswordReaml passwordReaml(RedisCacheManager redisCacheManager){
        PasswordReaml passwordReaml=new PasswordReaml();
        passwordReaml.setCacheManager(redisCacheManager);
        return  passwordReaml;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        RetryLimitHashedCredentialsMatcher hashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher();

        return hashedCredentialsMatcher;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true); // this SETTING
        return proxyCreator;
    }


    public RedisSessionDAO redisSessionDAO(){
        RedisSessionDAO  sessionDAO=new RedisSessionDAO();
        sessionDAO.redisTemplate=redisTemplate;
        return sessionDAO;
    }

    @Bean
    public RedisCacheManager redisCacheManager() {
        RedisCacheManager manager=new RedisCacheManager();
        manager.setRedisTemplate(redisTemplate);
        return manager;
    }

    @Bean(name = "sessionManager")
    public SessionManager getSessionManage() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(3600000);
        sessionManager.setSessionValidationScheduler(getExecutorServiceSessionValidationScheduler());
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(getSessionIdCookie());
        //  EnterpriseCacheSessionDAO cacheSessionDAO = new RedisSessionDAO();
        sessionManager.setCacheManager(redisCacheManager());
        sessionManager.setSessionDAO(redisSessionDAO());
        // -----可以添加session 创建、删除的监听器
        return sessionManager;
    }


    @Bean(name = "sessionValidationScheduler")
    public ExecutorServiceSessionValidationScheduler getExecutorServiceSessionValidationScheduler() {
        ExecutorServiceSessionValidationScheduler scheduler = new ExecutorServiceSessionValidationScheduler();
        scheduler.setInterval(900000);
        return scheduler;
    }


    @Bean(name = "rememberMeCookie")
    public SimpleCookie getRememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(2592000);//30天
        return simpleCookie;
    }


    @Bean(name = "sessionIdCookie")
    public SimpleCookie getSessionIdCookie() {
        SimpleCookie cookie = new SimpleCookie("mysid");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        return cookie;
    }


    @Bean(name = "rememberMeManager")
    public CookieRememberMeManager getCookieRememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager =
                new CookieRememberMeManager();
        cookieRememberMeManager.setCipherKey(
                org.apache.shiro.codec.Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        cookieRememberMeManager.setCookie(getRememberMeCookie());
        return cookieRememberMeManager;
    }

}