package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()            // 定义哪些URL需要被保护、哪些不需要被保护
//                .antMatchers("/").permitAll()                      //请求路径"/"允许访问
//                .anyRequest().authenticated()                      //其它请求都需要校验才能访问
//                .and()
//                .formLogin()                                // 定义当需要用户登录时候，转到的登录页面。
//                .loginPage("/login")                             //定义登录的页面"/login"，允许访问
//                .permitAll()
//                .and()
//                .logout()                                           //默认的"/logout", 允许访问
//                .permitAll();
    }

}