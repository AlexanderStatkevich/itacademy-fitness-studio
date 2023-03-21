package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.serialization.UnixSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductDto(
        UUID uuid,
        @JsonProperty(value = "dt_create")
        @JsonSerialize(using = UnixSerializer.class)
        LocalDateTime dateTimeCreate,
        @JsonProperty(value = "dt_update")
        @JsonSerialize(using = UnixSerializer.class)
        LocalDateTime dateTimeUpdate,
        String title,
        BigDecimal weight,
        BigDecimal calories,
        BigDecimal proteins,
        BigDecimal fats,
        BigDecimal carbohydrates
) {
}
