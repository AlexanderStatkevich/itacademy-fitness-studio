package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.product.dto;

import java.math.BigDecimal;

public record ProductCreateDto(
        String title,
        BigDecimal weight,
        BigDecimal calories,
        BigDecimal proteins,
        BigDecimal fats,
        BigDecimal carbohydrates
) {
}

/*
JSON product create and update object
{
  "title": "Гречка",
  "weight": 100,
  "calories": 308,
  "proteins": 12.6,
  "fats": 3.3,
  "carbohydrates": 57.1
}
 */
