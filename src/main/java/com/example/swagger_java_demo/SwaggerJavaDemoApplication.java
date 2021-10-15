package com.example.swagger_java_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerJavaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerJavaDemoApplication.class, args);
	}

	static {
		io.swagger.v3.core.jackson.ModelResolver.enumsAsRef = true;
	}
}
