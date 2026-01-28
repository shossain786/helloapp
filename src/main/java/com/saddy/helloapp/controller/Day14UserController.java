package com.saddy.helloapp.controller;

import com.saddy.helloapp.dto.UserResponse;
import com.saddy.helloapp.model.UserEntity;
import com.saddy.helloapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Day14UserController {
    UserService userService;

    public Day14UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users14")
    public ResponseEntity<?> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<UserResponse> users = userService.getUsers(page, size, sortBy);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users14/{id}")
    public ResponseEntity<UserResponse> getUsersById(@PathVariable Long id) {
        UserResponse user = userService.getUserById14(id);

//        return new ResponseEntity<>(user, HttpStatus.OK);
        return ResponseEntity.ok(user);
    }
}
