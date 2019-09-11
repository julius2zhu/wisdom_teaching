package com.julius.wisdom_teaching.config;

import com.julius.wisdom_teaching.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * author julius.zhu
 * date   2019/8/26
 * time   17:54
 * describe:
 * shiro配置的核心类
 */
@Configuration
public class ShiroConfiguration {
    //数据源
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    //加密器
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(3);
        return matcher;
    }

    //核心安全管理器
    @Bean
    public SecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    //过滤器相关
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());
        //默认跳转的登陆请求,使用/即可
        shiroFilterFactoryBean.setLoginUrl("/");
        shiroFilterFactoryBean.setUnauthorizedUrl("/404");
//        shiroFilterFactoryBean.setSuccessUrl("/");
        Map<String, String> chains = new HashMap<>();
        //创建一些拦截规则
        chains.put("/wisdom_teaching/login", "anon");
        //公共静态资源可以匿名访问
        chains.put("/dist/**", "anon");
        //这个拦截需要放到最后
//        chains.put("/**", "authc");
        //所有请求都可匿名访问,开发时候可以使用
        chains.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(chains);
        return shiroFilterFactoryBean;
    }
}
