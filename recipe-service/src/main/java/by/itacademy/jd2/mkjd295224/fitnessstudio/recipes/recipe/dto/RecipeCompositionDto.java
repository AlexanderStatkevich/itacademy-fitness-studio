package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.ProductDto;

import java.math.BigDecimal;

public record RecipeCompositionDto(
        ProductDto product,
        BigDecimal weight,
        BigDecimal calories,
        BigDecimal proteins,
        BigDecimal fats,
        BigDecimal carbohydrates
) {
}
