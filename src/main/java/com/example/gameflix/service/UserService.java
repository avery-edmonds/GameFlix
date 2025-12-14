package com.example.gameflix.service;

import com.example.gameflix.model.User;
import com.example.gameflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.print.attribute.standard.PrintQuality;
import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;
    //private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        //this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<User> searchByUsername(String username) {
        return userRepository.findByUsernameContainingIgnoreCase(username);
    }

    public List<User> getAllUsers() { return userRepository.findAll(); }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User login(String username, String password) {
       User user;

       user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Invalid Username/Email or Password!");
        }
        return userRepository.findById(user.getId()).orElseThrow(()-> new RuntimeException("User not found"));
    }



}