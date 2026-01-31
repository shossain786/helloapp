package com.saddy.helloapp.controller;

import com.saddy.helloapp.dto.UserResponse;
import com.saddy.helloapp.service.UserServiceV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Day17UserController {
    private UserServiceV2 userServiceV2;

    public Day17UserController(UserServiceV2 userServiceV2) {
        this.userServiceV2 = userServiceV2;
    }


    @GetMapping("/users17")
    public ResponseEntity<Page<UserResponse>> getUsers(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
            ){
        Page<UserResponse> users = userServiceV2.searchUser(search, page, size, sortBy);
        return ResponseEntity.ok(users);
    }
}
