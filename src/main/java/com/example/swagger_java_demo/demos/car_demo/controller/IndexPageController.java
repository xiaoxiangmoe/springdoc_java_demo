package com.example.swagger_java_demo.demos.car_demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "IndexPageController", description = "首页 Controller")
public class IndexPageController {

    @GetMapping("/")
    @Operation(
            summary = "首页",
            description = "获取首页啊，咱可以在这儿详细说明了一番，可选"
    )
    public String getIndexPage() {
        return "Greetings from Spring Boot!";
    }

}
