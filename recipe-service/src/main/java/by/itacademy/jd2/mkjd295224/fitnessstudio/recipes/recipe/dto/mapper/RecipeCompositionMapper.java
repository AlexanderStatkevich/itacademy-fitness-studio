package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Recipe;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.RecipeComposition;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeCompositionCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = EntityMapper.class)
public interface RecipeCompositionMapper {
    @Mapping(target = "recipe", source = "recipe")
    @Mapping(target = "product", source = "source.product")
    @Mapping(target = "weight", source = "source.weight")
    RecipeComposition toEntity(RecipeCompositionCreateDto source, Recipe recipe);
}
