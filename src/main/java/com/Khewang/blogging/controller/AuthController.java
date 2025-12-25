package com.Khewang.blogging.controller;


import com.Khewang.blogging.payload.JwtAuthRequest;
import com.Khewang.blogging.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    AuthService service;


    @PostMapping("/login")
    public String  createToken(@RequestBody JwtAuthRequest user){


        return service.verify(user);
    }
}
