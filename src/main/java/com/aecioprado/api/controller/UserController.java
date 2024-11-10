package com.aecioprado.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aecioprado.api.model.User;
import com.aecioprado.api.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> listUsers() {
        return (List<User>) userRepository.findAll();
    }
}
