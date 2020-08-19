package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class TestController {
    private UserService userService;
    @Autowired
    public TestController(
            UserService userService
    ) {
        this.userService = userService;
    }



}
