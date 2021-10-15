package com.example.swagger_java_demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

@Schema(description = "赛车")
public class RaceCar extends Car {
    @Schema(description = "颜色")
    @NotNull
    public String color;
}
