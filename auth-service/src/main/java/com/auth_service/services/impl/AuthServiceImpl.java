package com.auth_service.services.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.auth_service.components.JwtAuthenticationFilter;
import com.auth_service.components.JwtTokenProvider;
import com.auth_service.entities.User;
import com.auth_service.repositories.AuthRepository;
import com.auth_service.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {


    private AuthRepository authRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;


    public AuthServiceImpl(AuthRepository authRepository, PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String register(User user) {
        if(authRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        authRepository.save(user);
        return "User registered successfully!";
    }

    @Override
    public String login(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        return jwtTokenProvider.generateToken(email);
    }

}
