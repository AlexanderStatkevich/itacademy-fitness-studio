package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.UUID;

public record RecipeCompositionCreateDto(
        @NotBlank
        @org.hibernate.validator.constraints.UUID
        UUID product,
        @PositiveOrZero
        BigDecimal weight
) {
}
