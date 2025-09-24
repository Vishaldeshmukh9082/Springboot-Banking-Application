package com.auth_service.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_service.entities.User;
import com.auth_service.services.impl.AuthServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthServiceImpl authServiceImpl;


    public AuthController(AuthServiceImpl authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return ResponseEntity.ok(authServiceImpl.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String,String> request) {
        String email = request.get("email");
        String password = request.get("password");
        return ResponseEntity.ok(authServiceImpl.login(email, password));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Logout successful. Please remove token on client side.");
    }


}
