package by.itacademy.jd2.mkjd295224.fitnessstudio.service.api;

import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.recipe.RecipeDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IRecipeService {
    void create(RecipeDto recipeDto);

    List<RecipeDto> findAll();

    void update(UUID uuid, LocalDateTime dtUpdate, RecipeDto recipeDto);
}
