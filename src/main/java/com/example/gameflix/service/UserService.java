package com.example.gameflix.service;

import com.example.gameflix.model.User;
import com.example.gameflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String register(User user) {
       var result = userRepository.findByUsername(user.getUsername());

        if (result.isPresent()) {
            return "Username already exists";
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "User registered successfully";
    }

    public List<User> getAllUsers() { return userRepository.findAll(); }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public String login(User user) {
        var result = userRepository.findByUsername(user.getUsername());
        if (result.isEmpty()) {
            return "Invalid username or password";
        }

        boolean matches = passwordEncoder.matches(user.getPassword(), result.get().getPassword());
        if (matches) {
            return "Login successful";
        }
        else{
            return "Invalid username or password";
        }
    }



}