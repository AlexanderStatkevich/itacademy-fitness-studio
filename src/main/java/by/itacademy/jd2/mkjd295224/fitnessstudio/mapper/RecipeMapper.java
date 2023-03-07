package by.itacademy.jd2.mkjd295224.fitnessstudio.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.Recipe;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.recipe.RecipeCreateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.recipe.RecipeDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface RecipeMapper {

    Recipe toEntity(RecipeCreateDto source);

    RecipeDto toDto(Recipe source);

    void map(RecipeCreateDto source, @MappingTarget Recipe target);
}
