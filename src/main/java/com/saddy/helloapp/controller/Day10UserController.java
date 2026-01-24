package com.saddy.helloapp.controller;

import com.saddy.helloapp.model.UserEntity;
import com.saddy.helloapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day10UserController {
    private final UserService userService;

    public Day10UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getAllUsers(@PathVariable Long id) {
        UserEntity userEntity = userService.getUserById(id);

        return new ResponseEntity<>(userEntity,  HttpStatus.OK);
    }
}
