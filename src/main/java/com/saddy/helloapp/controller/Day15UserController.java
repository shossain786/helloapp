package com.saddy.helloapp.controller;

import com.saddy.helloapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Day15UserController {
    UserService userService;
    public Day15UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/users15/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("users_15/{id}")
    public ResponseEntity<Void> softDeleteUser(@PathVariable Long id){
        userService.softDeleteUserById(id);

        return ResponseEntity.noContent().build();
    }
}
