package com.example.demo.controller;

import com.example.demo.auth.ReqUser;
import com.example.demo.entity.User;
import com.example.demo.exceptionhandling.BadRequestException;
import com.example.demo.service.UserService;
import com.example.demo.service.contract.DTOBuilderService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sun.security.util.Debug;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUser() {
        List<User> users = userService.findAllUser();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@ReqUser User user) {
        return ResponseEntity.ok(user);
    }
    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user, UriComponentsBuilder builder){
        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/products/{id}")
                .buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
