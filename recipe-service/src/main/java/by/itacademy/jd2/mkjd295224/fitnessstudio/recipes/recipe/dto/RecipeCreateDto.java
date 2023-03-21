package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record RecipeCreateDto(
        @NotBlank
        String title,
        List<RecipeCompositionCreateDto> composition
) {
}
