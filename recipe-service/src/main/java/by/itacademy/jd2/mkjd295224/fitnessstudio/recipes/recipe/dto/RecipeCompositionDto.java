package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

@JsonPropertyOrder({
        "product",
        "weight",
        "calories",
        "proteins",
        "fats",
        "carbohydrates"
})
public record RecipeCompositionDto(
        ProductDto product,
        BigDecimal weight,
        BigDecimal calories,
        BigDecimal proteins,
        BigDecimal fats,
        BigDecimal carbohydrates
) {
}
