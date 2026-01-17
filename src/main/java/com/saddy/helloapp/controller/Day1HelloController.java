package com.saddy.helloapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day1HelloController {

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot🙂";
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello, Welcome to Spring Boot!";
    }

}
