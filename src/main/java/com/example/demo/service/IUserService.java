package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface IUserService {
    User findUserByEmail(String email);
    User findUserByUsername(String userName);
    User saveUser(User user);
}
