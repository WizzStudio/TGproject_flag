package com.ctg.flag.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final String USER_QUERY = "SELECT openid AS username FROM user WHERE openid = ?";
    private final String AUTH_QUERY = "SELECT openid AS username, state AS authority FROM user WHERE openid = id";
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()  // 关闭 csrf
                .disable()
                .authorizeRequests()
                .antMatchers("/user/**").permitAll()  // 允许任意用户访问 /user/
                .anyRequest()   // 限制非登录用户访问任何内容
                .permitAll();
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/user")  // 登录的指向地址
//                .usernameParameter("code")  // 做username 的 属性名
//                ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery(USER_QUERY)
                .authoritiesByUsernameQuery(AUTH_QUERY);
    }
}
