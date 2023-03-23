package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Recipe;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeCreateUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IRecipeService {
    void create(RecipeCreateUpdateDto recipeCreateUpdateDto);

    Page<Recipe> findAll(Pageable pageable);

    void update(UUID uuid, LocalDateTime dtUpdate, RecipeCreateUpdateDto recipeCreateUpdateDto);
}
