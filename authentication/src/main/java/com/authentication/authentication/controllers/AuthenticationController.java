package com.authentication.authentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.authentication.dto.UserDto;
import com.authentication.authentication.entities.User;
import com.authentication.authentication.services.implementation.AuthenticationServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthenticationController {

    private AuthenticationServiceImpl authenticationServiceImpl;

    public AuthenticationController(AuthenticationServiceImpl authenticationServiceImpl) {
        this.authenticationServiceImpl = authenticationServiceImpl;
    }

    @GetMapping("/user/")
    @ResponseBody
    public String home(){
        return "Welcome Home";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user) {
        
        authenticationServiceImpl.saveUser(user);

        return "Register Scuccesfuly";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody UserDto userDto) {

        return "login";
    }
    
    



}
