package com.saddy.helloapp.controller;

import com.saddy.helloapp.model.UserEntity;
import com.saddy.helloapp.model.UserPatchRequest;
import com.saddy.helloapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day12UserController {

    private final UserService userService;
    public Day12UserController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<UserEntity> patchUser(
            @PathVariable Long id,
            @Valid @RequestBody UserPatchRequest request) {
        UserEntity updatedUser = userService.patchUser(id, request);
        return new  ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
