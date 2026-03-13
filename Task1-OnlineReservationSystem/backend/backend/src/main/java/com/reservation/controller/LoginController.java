package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.User;
import com.reservation.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = userRepository.findByUsernameAndPassword(
                user.getUsername(),
                user.getPassword()
        );

        if(existingUser != null){
            return "Login Successful";
        } else {
            return "Invalid Username or Password";
        }
    }
}