package com.saddy.helloapp.controller;

import com.saddy.helloapp.model.UserV2;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day4UserController {

    @PostMapping("/users2")
    public ResponseEntity<String> addUser(@Valid @RequestBody UserV2 user) {
        String response = "User created!\nUser Name: " + user.getName() +
                "\nUser age: " + user.getAge() +
                "\nEmail: " + user.getEmail();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
