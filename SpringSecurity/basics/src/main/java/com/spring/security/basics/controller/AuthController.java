package com.spring.security.basics.controller;

import com.spring.security.basics.dto.UserLoginRequest;
import com.spring.security.basics.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserLoginRequest loginRequest) {

        System.out.println("Into it (for debugging)");

       return authService.loginService(loginRequest);


    }
}
