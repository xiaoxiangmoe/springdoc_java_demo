package com.example.swagger_java_demo.configs;

import io.swagger.v3.core.converter.ModelConverters;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    static {
        io.swagger.v3.core.jackson.ModelResolver.enumsAsRef = true;
        ModelConverters.getInstance().addConverter(new EnumModelConverter());
    }

    @Bean
    public OperationCustomizer operationIdCustomizer() {
        return (operation, handlerMethod) -> {
            String beanName = handlerMethod.getBeanType().getSimpleName();
            String methodName = handlerMethod.getMethod().getName();
            operation.setOperationId(
                    beanName.substring(0, 1).toLowerCase() +
                            beanName.substring(1) +
                            methodName.substring(0, 1).toUpperCase() +
                            methodName.substring(1)
            );
            return operation;
        };
    }
}
