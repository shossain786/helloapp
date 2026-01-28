package com.saddy.helloapp.controller;

import com.saddy.helloapp.model.UserEntity;
import com.saddy.helloapp.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day13UserController {
    UserService userService;

    Day13UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/users13")
//    public ResponseEntity<Page<UserEntity>> getUsers(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "2") int size,
//            @RequestParam(defaultValue = "id") String sortBy
//    ) {
//        Page<UserEntity> users = userService.getUsers(page, size, sortBy);
//
//        return new ResponseEntity<>(users, HttpStatus.OK);

//    }
}
