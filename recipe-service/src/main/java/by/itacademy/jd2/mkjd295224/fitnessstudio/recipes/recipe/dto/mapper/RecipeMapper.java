package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Recipe;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeCreateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = EntityMapper.class)
public interface RecipeMapper {

    Recipe toEntity(RecipeCreateDto source);

    RecipeDto toDto(Recipe source);

    void map(RecipeCreateDto source, @MappingTarget Recipe target);
}
