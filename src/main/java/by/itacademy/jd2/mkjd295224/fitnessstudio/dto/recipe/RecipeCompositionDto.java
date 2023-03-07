package by.itacademy.jd2.mkjd295224.fitnessstudio.dto.recipe;

import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.product.ProductDto;

import java.math.BigDecimal;

public record RecipeCompositionDto(
        ProductDto productDto,
        BigDecimal weight,
        BigDecimal calories,
        BigDecimal proteins,
        BigDecimal fats,
        BigDecimal carbohydrates
) {
}
/*
JSON composition return object
    {
          "product": {
            "uuid": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
            "dt_create": 0,
            "dt_update": 0,
            "title": "Гречка",
            "weight": 100,
            "calories": 308,
            "proteins": 12.6,
            "fats": 3.3,
            "carbohydrates": 57.1
          },
          "weight": 50,
          "calories": 154,
          "proteins": 6.3,
          "fats": 1.65,
          "carbohydrates": 28.55
        }
 */
