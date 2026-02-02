package com.saddy.helloapp.controller;

import com.saddy.helloapp.dto.UserResponse;
import com.saddy.helloapp.service.UserServiceV3;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Day19UserController {
    private final UserServiceV3 userServiceV3;

    public Day19UserController(UserServiceV3 userServiceV3) {
        this.userServiceV3 = userServiceV3;
    }

    @GetMapping("/users19")
    public ResponseEntity<Page<UserResponse>> getUsers(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.ok(userServiceV3.searchUsers(search, page, size, sortBy));
    }
}
