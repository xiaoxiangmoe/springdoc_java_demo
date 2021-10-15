package com.example.swagger_java_demo.demos.car_demo.controller;

import com.example.swagger_java_demo.demos.car_demo.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@Tag(name = "CarController", description = "车辆")
public class CarController {
    @GetMapping("/cars")
    @Operation(
            summary = "获得车列表",
            description = "这是车车啊啊啊啊，详细说明了一番，当然也可以省略"
    )
    public Result<Page<Car>> getCarList(
            @Parameter(description = "车子的最低价格") @RequestParam(required = false) Long minPrice
    ) {
        SportCar sportCar = new SportCar();
        sportCar.brand = "红旗";
        sportCar.price = 114514;
        sportCar.acceleration = 1;
        sportCar.powerType = PowerType.battery;
        sportCar.countryCodeOfProduction = Country.China;

        Page<Car> carPage = new Page<>();
        carPage.count = 2;
        carPage.rows = Arrays.asList(sportCar, sportCar);

        return Result.ok(carPage);
    }

    @PostMapping("/cars")
    @Operation(
            summary = "创建一辆车",
            description = "这是创建车车啊啊啊啊，详细说明了一番，当然也可以省略"
    )
    public Result<Car> createCar(
            @RequestBody(required = false) Car car
    ) {
        return Result.ok(car);
    }


    @GetMapping("/best-car/{brand}")
    @Operation(
            summary = "获得某个品牌最好的车",
            description = "这是车啊啊啊啊，详细说明了一番，当然也可以省略"
    )
    public Result<Car> getBestCar(
            @Parameter(description = "车子的加速度") @RequestParam(required = false, defaultValue = "10") int acceleration,
            @Parameter(description = "车子的品牌") @PathVariable(required = true) String brand
    ) {
        SportCar sportCar = new SportCar();
        sportCar.brand = brand;
        sportCar.price = 114514;
        sportCar.acceleration = acceleration;
        sportCar.powerType = PowerType.battery;
        sportCar.countryCodeOfProduction = Country.China;
        return Result.ok(sportCar);
    }
}
