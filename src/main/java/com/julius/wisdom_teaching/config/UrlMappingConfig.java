package com.julius.wisdom_teaching.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   16:11
 * describe:
 * 请求地址映射配置类
 */
@Configuration
public class UrlMappingConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
}
