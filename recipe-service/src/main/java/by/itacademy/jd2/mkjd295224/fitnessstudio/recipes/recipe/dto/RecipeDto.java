package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record RecipeDto(
        UUID uuid,
        LocalDateTime dateCreate,
        LocalDateTime dateUpdate,
        String title,
        List<RecipeCompositionCreateDto> composition,
        BigDecimal weight,
        BigDecimal calories,
        BigDecimal proteins,
        BigDecimal fats,
        BigDecimal carbohydrates
) {
}
/*
    {
      "uuid": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
      "dt_create": 0,
      "dt_update": 0,
      "title": "Гречка с лисичками",
      "composition": [
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
      ],
      "weight": 50,
      "calories": 154,
      "proteins": 6.3,
      "fats": 1.65,
      "carbohydrates": 28.55
    }
 */
