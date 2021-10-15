package com.example.swagger_java_demo.demos.car_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @GetMapping(value = "/hi/index")
    public String index() {
        return "Greetings Hello from Spring Boot!";
    }
}