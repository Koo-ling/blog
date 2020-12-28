package com.blog.config;

import com.blog.utils.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
    @Bean
    UserDetailsService customUserService() { //2
        return new MemberService();
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();//解决跨域访问问题
        http.authorizeRequests()//权限设置
//               .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/","/index","/boke/**","/single","/user/save").permitAll()
                .anyRequest().authenticated()//以下路径需要身份验证
                .and()
                .formLogin().loginPage("/login")
                    .failureUrl("/login?/error")
                    .permitAll()
                .and()
                .logout().permitAll();
    }


}
