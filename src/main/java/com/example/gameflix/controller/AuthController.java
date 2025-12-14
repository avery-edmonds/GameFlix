package com.example.gameflix.controller;

import com.example.gameflix.model.User;
import com.example.gameflix.repository.UserRepository;
import com.example.gameflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    UserService userService;
    UserRepository userRepository;

    AuthController(UserService userService, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }


    // REST endpoints for login & registration
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        userRepository.save(user);
        return "Login created successfully";

    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
       return userService.login(username, password);

    }
}
