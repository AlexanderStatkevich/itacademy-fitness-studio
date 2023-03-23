package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Recipe;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeCreateUpdateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeDto;
import org.mapstruct.Mapper;

@Mapper(uses = EntityMapper.class)
public interface RecipeMapper {

    Recipe toEntity(RecipeCreateUpdateDto source);

    RecipeDto toDto(Recipe source);
}
