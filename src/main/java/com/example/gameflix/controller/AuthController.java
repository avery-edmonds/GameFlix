package com.example.gameflix.controller;

import com.example.gameflix.model.User;
import com.example.gameflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController

public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody User user){
        String message = userService.register(user);
        return Map.of("message",message);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user){
        String message = userService.login(user);
        return Map.of("message",message);
    }
}
