package com.auth_service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth_service.entities.User;

@Repository
public interface AuthRepository extends JpaRepository<User,String>{
       Optional<User> findByEmail(String email);

}
