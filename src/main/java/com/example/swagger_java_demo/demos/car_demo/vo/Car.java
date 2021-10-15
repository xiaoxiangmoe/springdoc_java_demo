package com.example.swagger_java_demo.demos.car_demo.vo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.NOT_REQUIRED;
import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(
        description = "抽象的车",
        discriminatorMapping = {
                @DiscriminatorMapping(value = "RaceCar", schema = RaceCar.class),
                @DiscriminatorMapping(value = "SportCar", schema = SportCar.class)
        },
        oneOf = {
                RaceCar.class,
                SportCar.class
        }
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RaceCar.class),
        @JsonSubTypes.Type(value = SportCar.class)
})
public abstract class Car {
    @Schema(description = "品牌", requiredMode = REQUIRED)
    @Deprecated
    public String brand;

    @Schema(description = "价格", requiredMode = NOT_REQUIRED)
    public int price;
}
