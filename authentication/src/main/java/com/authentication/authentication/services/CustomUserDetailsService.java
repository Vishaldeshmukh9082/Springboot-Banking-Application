package com.authentication.authentication.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authentication.authentication.config.CustomUserDetails;
import com.authentication.authentication.repositories.AuthRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private AuthRepository authRepository;

    public CustomUserDetailsService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return new CustomUserDetails(authRepository.findByEmail(username).orElseThrow(()->new RuntimeException("username")));
        
    }

}
