package com.saddy.helloapp.controller;

import com.saddy.helloapp.dto.UserResponse;
import com.saddy.helloapp.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Day16UserController {
    private UserService userService;

    public Day16UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users16/{id}")
    public ResponseEntity<UserResponse> getUsers16ById(@PathVariable Long id) {
        UserResponse userResponse = userService.getUserByIdActive(id);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/users16")
    public ResponseEntity<?> getUsers16(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<UserResponse> userResponsePage = userService.getUsersActive(page, size, sortBy);
        return ResponseEntity.ok(userResponsePage);
    }
}
