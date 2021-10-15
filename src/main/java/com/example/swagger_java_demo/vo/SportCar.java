package com.example.swagger_java_demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class SportCar extends Car {
    @Schema(description = "颜色")
    @NotNull
    public int acceleration;

    @Schema(description = "能源")
    @NotNull
    public PowerType powerType;

    @Schema(description = "生产国")
    @NotNull
    public Country countryCodeOfProduction;
}
