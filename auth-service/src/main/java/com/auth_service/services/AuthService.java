package com.auth_service.services;

import com.auth_service.entities.User;

public interface AuthService {
    String register(User user);
    String login(String email, String password);
}
