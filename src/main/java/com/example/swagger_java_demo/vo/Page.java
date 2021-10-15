package com.example.swagger_java_demo.vo;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Page<T> {
    @NotNull
    public long count;
    @NotNull
    public List<T> rows;
}
