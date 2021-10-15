package com.example.swagger_java_demo.demos.car_demo.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public class Result<T> {

    @Schema(requiredMode = REQUIRED)
    public String msg;
    @Schema(requiredMode = REQUIRED)
    public int status;
    @Schema(requiredMode = REQUIRED)
    public T data;

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.msg = "ok";
        result.status = 0;
        result.data = data;
        return result;
    }
}
