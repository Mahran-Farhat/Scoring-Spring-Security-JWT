package com.funsoft.cabinet.security.services;

import com.funsoft.cabinet.model.User;
import com.funsoft.cabinet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository agent;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = agent.findByUsername(s).orElseThrow(
                ()-> new UsernameNotFoundException("User Not found with username :"+s)
        );

        return UserDetailsImpl.build(user);
    }
}
