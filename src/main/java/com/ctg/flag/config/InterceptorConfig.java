package com.ctg.flag.config;

import com.ctg.flag.web.interceptor.AuthenticationInterceptor;
import com.ctg.flag.web.interceptor.UserInfoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
    private AuthenticationInterceptor authenticationInterceptor;
    private UserInfoInterceptor userInfoInterceptor;

    public InterceptorConfig(
            AuthenticationInterceptor authenticationInterceptor,
            UserInfoInterceptor userInfoInterceptor) {
        this.authenticationInterceptor = authenticationInterceptor;
        this.userInfoInterceptor = userInfoInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**").excludePathPatterns("/user/login");
        registry.addInterceptor(userInfoInterceptor).addPathPatterns("/**").excludePathPatterns("/user/**", "/place");
    }
}
