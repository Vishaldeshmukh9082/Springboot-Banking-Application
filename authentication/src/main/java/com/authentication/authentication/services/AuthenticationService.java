package com.authentication.authentication.services;

import com.authentication.authentication.entities.User;

public interface AuthenticationService {

    User login(String email,String password);

    User saveUser(User user);
    
}
