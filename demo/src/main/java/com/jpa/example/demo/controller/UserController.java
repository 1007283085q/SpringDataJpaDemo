package com.jpa.example.demo.controller;

import com.jpa.example.demo.dao.UserRepository;
import com.jpa.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "user", consumes = (MediaType.APPLICATION_JSON_VALUE))
    public User addNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping(path = "users")
    public Page<User> getAllUsers(Pageable request) {
        return userRepository.findAll(request);
    }
}
