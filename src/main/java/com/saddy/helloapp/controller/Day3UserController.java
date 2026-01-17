package com.saddy.helloapp.controller;

import com.saddy.helloapp.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day3UserController {

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        if (user.getAge() <= 0) {
            return "Age must be greater than 0";
        }
        return  "User created!\nUser Name: " + user.getName() +
                "\nUser age: " + user.getAge() +
                "\nEmail: " + user.getEmail();
    }
}
