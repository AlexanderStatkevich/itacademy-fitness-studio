package by.itacademy.jd2.mkjd295224.fitnessstudio.dto.recipe;

import java.util.List;

public record RecipeCreateDto(
        String title,
        List<RecipeCompositionCreateDto> composition
) {
}
/*
JSON recipe create and update object
{
  "title": "Гречка с лисичками",
  "composition": [
    {
      "product": {},
      "weight": 100
    }
  ]
}
 */
