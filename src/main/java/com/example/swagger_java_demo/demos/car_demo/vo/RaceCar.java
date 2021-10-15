package com.example.swagger_java_demo.demos.car_demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "赛车")
public class RaceCar extends Car {
    @Schema(description = "颜色", requiredMode = REQUIRED)
    public String color;
}
