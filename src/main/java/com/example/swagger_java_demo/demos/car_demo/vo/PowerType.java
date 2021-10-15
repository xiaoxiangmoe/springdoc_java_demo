package com.example.swagger_java_demo.demos.car_demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "能源类型")
public enum PowerType {
    @Schema(description = "汽油")
    gasoline,
    @Schema(description = "电池")
    battery
}
