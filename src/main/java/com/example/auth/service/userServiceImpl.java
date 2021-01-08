package com.example.auth.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Jianping Yu
 * @date 2021/1/8
 */
@Component
public class userServiceImpl implements UserDetailsService {
    @Resource
    PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User("admin2",encoder.encode("admin2"), AuthorityUtils.commaSeparatedStringToAuthorityList("test"));

        return user;
    }
}
