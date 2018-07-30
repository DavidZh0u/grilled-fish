package com.demo.web.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        // 排除路径
        loginRegistry.excludePathPatterns("/login");
        loginRegistry.excludePathPatterns("/check");
        loginRegistry.excludePathPatterns("/out");
        loginRegistry.excludePathPatterns("/404");
        loginRegistry.excludePathPatterns("/actuator/health");
        // 排除资源请求
        loginRegistry.excludePathPatterns("/css/**");
        loginRegistry.excludePathPatterns("/fonts/**");
        loginRegistry.excludePathPatterns("/images/**");
        loginRegistry.excludePathPatterns("/js/**");
        loginRegistry.excludePathPatterns("/layui/**");
    }
}