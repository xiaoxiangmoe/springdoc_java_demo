package com.example.swagger_java_demo.configs;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.JavaType;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverter;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.core.jackson.AbstractModelConverter;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class EnumModelConverter extends AbstractModelConverter {
     public static class EnumDetail {
        @NotNull
        public final String name;
        @NotNull
        public final Object value;
        @Nullable
        public final String description;

        EnumDetail(@NotNull String name, @NotNull Object value, @Nullable String description) {
            this.name = name;
            this.value = value;
            this.description = description;
        }
    }

    public EnumModelConverter() {
        super(Json.mapper());
    }

    final String CUSTOM_KEY = "x-ks-enum-detail";

    @Override
    public Schema<?> resolve(AnnotatedType annotatedType, ModelConverterContext context, Iterator<ModelConverter> next) {
        final Schema<?> originalRefSchema = super.resolve(annotatedType, context, next);

        final JavaType type = annotatedType.getType() instanceof JavaType ?
                (JavaType) annotatedType.getType() :
                _mapper.constructType(annotatedType.getType());

        if (type == null || !type.isEnumType() || originalRefSchema == null) {
            return originalRefSchema;
        }

        @SuppressWarnings("unchecked")
        final Class<Enum<?>> enumClass = (Class<Enum<?>>) type.getRawClass();

        final String name = originalRefSchema.get$ref().substring(Components.COMPONENTS_SCHEMAS_REF.length());
        final Schema<?> definedModel = context.getDefinedModels().get(name);

        @Nullable
        final Map<String, Object> modelExtensions = definedModel.getExtensions();

        if (modelExtensions != null && modelExtensions.containsKey(CUSTOM_KEY)) {
            return originalRefSchema;
        }

        final boolean isNumberSchema = Arrays.stream(enumClass.getMethods())
                .filter(m -> m.isAnnotationPresent(JsonValue.class))
                .map(m -> ClassUtils.isAssignable(m.getReturnType(), Number.class, true))
                .findFirst()
                .orElse(false);
        final Schema<?> newModel;
        if (isNumberSchema) {
            NumberSchema numberSchema = new NumberSchema();
            numberSchema.setEnum(
                    definedModel.getEnum()
                            .stream()
                            .map(x -> new BigDecimal((String) x))
                            .collect(Collectors.toList())
            );
            context.defineModel(name, numberSchema);
            newModel = numberSchema;
        } else {
            newModel = definedModel;
        }

        final Enum<?>[] enumConstants = enumClass.getEnumConstants();
        newModel.addExtension(CUSTOM_KEY,
                IntStream.range(0, enumConstants.length).mapToObj(i -> {
                    final String enumConstantName = enumConstants[i].name();
                    Field declaredField = null;
                    try {
                        declaredField = enumClass.getDeclaredField(enumConstantName);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                    assert declaredField != null;
                    String description = Arrays.stream(declaredField.getAnnotations())
                            .filter(annotation -> annotation instanceof io.swagger.v3.oas.annotations.media.Schema)
                            .map(annotation -> ((io.swagger.v3.oas.annotations.media.Schema) annotation).description())
                            .findFirst()
                            .orElse(null);
                    return new EnumDetail(
                            enumConstantName,
                            newModel.getEnum().get(i),
                            description
                    );
                }).toArray());

        return originalRefSchema;
    }
}