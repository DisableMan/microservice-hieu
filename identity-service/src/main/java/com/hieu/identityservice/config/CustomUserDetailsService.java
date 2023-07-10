package com.hieu.identityservice.config;

import com.hieu.identityservice.entity.User;
import com.hieu.identityservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> credential = repository.findByName(username);
        return credential.map(CustomUserDetail::new).orElseThrow(() -> new UsernameNotFoundException("user not found with name :" + username));
    }
}
