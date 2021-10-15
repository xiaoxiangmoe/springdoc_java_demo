package com.example.swagger_java_demo.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        type = "integer",
        format = "int32",
        allowableValues = {"156", "276", "840"}
)
public enum Country {

    China(156),
    Germany(276),
    UnitedStatesOfAmerica(840);

    private final int numericCode;

    Country(int numericCode) {
        this.numericCode = numericCode;
    }

    @JsonValue
    public int getNumericCode() {
        return this.numericCode;
    }

}