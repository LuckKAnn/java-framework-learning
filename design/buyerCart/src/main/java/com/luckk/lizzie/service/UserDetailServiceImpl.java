package com.luckk.lizzie.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 17:05
 * @PackageName: com.luckk.lizzie.service
 * @ClassName: UserDetailServiceImpl
 * @Version 1.0
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("lkk", "paaword", new ArrayList<>());
    }
}
