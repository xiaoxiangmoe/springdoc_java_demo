package com.example.swagger_java_demo.demos.car_demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public class Page<T> {
    @Schema(requiredMode = REQUIRED)
    public long count;
    @Schema(requiredMode = REQUIRED)
    public List<T> rows;
}
