package com.saddy.helloapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day2GreetController {
    @GetMapping("/hi")
    public String greet(@RequestParam(required = false) String name) {
//        if no parameter received
        if (name == null) {
            return "Hello, Guest!";
        }
        return "Hello, " + name + "!";
    }

    @GetMapping("/hi/{path}")
    public String helloUser(@PathVariable String path) {
        return "Hello, " + path + "!";
    }

    @GetMapping("/add")
    public String addNum(@RequestParam(required = false) Integer a,
                         @RequestParam(required = false) Integer b) {
        IO.println("a: " + a + ", b: " + b);
        if (a == null || b == null) {
            return "Param missing!";
        }
        return "Sum: " + (a + b);
    }
}
