package com.example.swagger_java_demo.demos.car_demo.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "国家"
)
public enum Country {

    @Schema(description = "中国")
    China(156),
    @Schema(description = "德国")
    Germany(276),
    @Schema(description = "美国")
    UnitedStatesOfAmerica(840);

    /**
     * numeric geographical codes
     */
    private final int numericCode;

    Country(int numericCode) {
        this.numericCode = numericCode;
    }

    @JsonValue
    public int getNumericCode() {
        return this.numericCode;
    }

}
