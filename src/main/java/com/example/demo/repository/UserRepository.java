package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository  extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findById(int id);

}
