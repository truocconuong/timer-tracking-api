package com.example.demo.controller;

import com.example.demo.auth.ReqUser;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.contract.DTOBuilderService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Debug;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    DTOBuilderService dtoBuilderService;

    @Autowired
    UserService userService;


    @GetMapping
    public Object getData(@ReqUser User user) {
        return dtoBuilderService.buildUserDto(user);
    }


    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@ReqUser User user) {
        return ResponseEntity.ok(user);
    }
}
