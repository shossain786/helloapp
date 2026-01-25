package com.saddy.helloapp.controller;

import com.saddy.helloapp.exception.UserNotFoundException;
import com.saddy.helloapp.model.UserEntity;
import com.saddy.helloapp.repository.UserRepository;
import com.saddy.helloapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day11UserController {
    private final UserService userService;

    public Day11UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id,
                                                 @Valid @RequestBody UserEntity user) {
        UserEntity updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }
}
