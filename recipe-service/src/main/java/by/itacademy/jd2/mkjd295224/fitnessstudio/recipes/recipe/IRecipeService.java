package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Recipe;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IRecipeService {
    void create(RecipeCreateDto recipeCreateDto);

    Page<Recipe> findAll(Pageable pageable);

    void update(UUID uuid, LocalDateTime dtUpdate, RecipeCreateDto recipeCreateDto);
}
