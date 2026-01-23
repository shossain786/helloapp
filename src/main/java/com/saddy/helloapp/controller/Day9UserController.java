package com.saddy.helloapp.controller;

import com.saddy.helloapp.model.UserEntity;
import com.saddy.helloapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Day9UserController {
    private final UserService userService;
    public Day9UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users5")
    public ResponseEntity<UserEntity> addUser(@Valid @RequestBody UserEntity user) {

        UserEntity savedUser = userService.createUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users5")
    public ResponseEntity<List<UserEntity>> getUsers() {
        List<UserEntity> allUsers = userService.getUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
