package com.example.swagger_java_demo.demos.car_demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;


public class SportCar extends Car {
    @Schema(description = "加速度", requiredMode = REQUIRED)
    public int acceleration;

    @Schema(description = "能源", requiredMode = REQUIRED)
    public PowerType powerType;

    @Schema(description = "生产国", requiredMode = REQUIRED)
    public Country countryCodeOfProduction;
}
