package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record RecipeCompositionCreateDto(
        UUID productId,
        BigDecimal weight
) {
}
/*
JSON composition object
    {
      "product": {},
      "weight": 100
    }
 */
