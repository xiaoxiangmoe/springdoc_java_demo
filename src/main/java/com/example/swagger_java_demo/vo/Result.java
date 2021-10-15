package com.example.swagger_java_demo.vo;

import javax.validation.constraints.NotNull;

public class Result<T> {
    @NotNull
    public String msg;
    @NotNull
    public int status;
    @NotNull
    public T data;

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.msg = "ok";
        result.status = 0;
        result.data = data;
        return result;
    }
}
