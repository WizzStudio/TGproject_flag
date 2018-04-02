package com.ctg.flag.config;

import com.ctg.flag.web.interceptor.UserInfoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
    private UserInfoInterceptor userInfoInterceptor;

    public InterceptorConfig(UserInfoInterceptor userInfoInterceptor) {
        this.userInfoInterceptor = userInfoInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInfoInterceptor).addPathPatterns("/**").excludePathPatterns("/user/**", "/department");
    }
}
