package com.saddy.helloapp.controller;

import com.saddy.helloapp.model.UserV2;
import com.saddy.helloapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day6UserController {
    private final UserService userService;

    public Day6UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users4")
    public ResponseEntity<String> addUser(@Valid @RequestBody UserV2 user) {
        userService.createUser(user);
        return new ResponseEntity<>("User has been created", HttpStatus.CREATED);
    }
}
