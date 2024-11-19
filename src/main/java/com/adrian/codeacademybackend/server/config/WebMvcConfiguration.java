package com.adrian.codeacademybackend.server.config;

import com.adrian.codeacademybackend.server.interceptor.JwtInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*
 * Date: 2024/11/18 19:05
 * Author: Adrian
 * Version: 1.0
 * Description: 配置类，注册web层相关组件
 * */
@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义拦截器...");
        // 注册拦截器,添加自定义的jwt令牌校验的拦截器
        registry.addInterceptor(jwtInterceptor)
                // 拦截所有路径
                .addPathPatterns("/**")
                // 排除路径 "/user/login"
                .excludePathPatterns("/user/login")
                // 排除路径 "/user/register"
                .excludePathPatterns("/user/register");
    }
}
