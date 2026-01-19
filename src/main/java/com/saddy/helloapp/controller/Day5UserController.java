package com.saddy.helloapp.controller;

import com.saddy.helloapp.exception.DuplicateEmailException;
import com.saddy.helloapp.exception.InvalidUserException;
import com.saddy.helloapp.model.UserV2;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day5UserController {

    @PostMapping("/users3")
    public ResponseEntity<String> addUser(@Valid @RequestBody UserV2 user) {
        String existingEmail = "saddam.tech@in.com";
        if (user.getAge() > 100) {
            throw new InvalidUserException("Age must be between 0 and 100");
        }

        if (existingEmail.equalsIgnoreCase(user.getEmail())) {
            throw new DuplicateEmailException("Email already exists");
        }

        return new ResponseEntity<>("User Created Successfully", HttpStatus.CREATED);
    }
}
