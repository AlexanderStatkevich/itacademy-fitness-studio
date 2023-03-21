package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProductCreateUpdateDto(
        @NotBlank
        String title,
        @PositiveOrZero
        BigDecimal weight,
        @PositiveOrZero
        BigDecimal calories,
        @PositiveOrZero
        BigDecimal proteins,
        @PositiveOrZero
        BigDecimal fats,
        @PositiveOrZero
        BigDecimal carbohydrates
) {
}
