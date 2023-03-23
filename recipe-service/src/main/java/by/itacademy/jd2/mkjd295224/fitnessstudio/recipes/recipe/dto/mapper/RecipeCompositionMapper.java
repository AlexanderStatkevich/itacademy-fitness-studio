package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.RecipeComposition;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeCompositionCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface RecipeCompositionMapper {

    @Mapping(target = "product", ignore = true)
    void map(RecipeCompositionCreateDto source, @MappingTarget RecipeComposition recipe);
}
