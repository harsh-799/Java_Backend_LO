package com.spring.security.basics.controller;

import com.spring.security.basics.model.User;
import com.spring.security.basics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void createNewUsers(@RequestBody User user) {
        userService.addNewUsers(user);
    }
}
