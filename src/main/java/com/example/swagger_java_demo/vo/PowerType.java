package com.example.swagger_java_demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "能源类型，gasoline——汽油，battery——电池")
public enum PowerType {
    gasoline,
    battery
}
