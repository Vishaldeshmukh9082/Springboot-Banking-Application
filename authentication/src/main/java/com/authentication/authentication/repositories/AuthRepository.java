package com.authentication.authentication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.authentication.authentication.entities.User;

@Repository
public interface AuthRepository extends JpaRepository<User,String>{

   Optional<User> findByEmail(String email);

    
} 
