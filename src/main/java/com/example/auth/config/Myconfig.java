package com.example.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Jianping Yu
 * @date 2021/1/8
 */
@Configuration
public class Myconfig extends WebSecurityConfigurerAdapter {
    @Resource
    UserDetailsService userDetailsService;
    @Resource
    PasswordEncoder encoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String admin = encoder.encode("admin");
        auth.inMemoryAuthentication().withUser("admin").password(admin).roles("admin");
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
//        super.configure(auth);
    }

    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }
}
