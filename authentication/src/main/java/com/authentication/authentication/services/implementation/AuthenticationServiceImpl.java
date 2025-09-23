package com.authentication.authentication.services.implementation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authentication.authentication.entities.User;
import com.authentication.authentication.repositories.AuthRepository;
import com.authentication.authentication.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private AuthRepository authRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationServiceImpl(AuthRepository authRepository,PasswordEncoder passwordEncoder){
        this.authRepository=authRepository;
        this.passwordEncoder=passwordEncoder;
    }


    //Used for spring security 
    @Override
    public User login(String email, String password) {    
            return authRepository.findByEmail(email)
            .filter(user-> passwordEncoder.matches(password, user.getPassword()))
            .orElseThrow(()-> new RuntimeException("Invalid Email & Password"));
    }

    @Override
    public User saveUser(User user) {
        String uid=UUID.randomUUID().toString();
        user.setId(uid);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newuser=authRepository.save(user);
        return newuser;
    }

}
