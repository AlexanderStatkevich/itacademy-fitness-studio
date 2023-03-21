package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Recipe;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeCreateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.mapper.RecipeMapper;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RecipeService implements IRecipeService {

    private final IRecipeRepository repository;

    private final RecipeMapper mapper;

    public RecipeService(IRecipeRepository repository, RecipeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(RecipeCreateDto recipeCreateDto) {
        Recipe recipe = mapper.toEntity(recipeCreateDto);
        recipe.getComposition().forEach(composition -> {
            composition.setRecipe(recipe);
            composition.setUuid(UUID.randomUUID());
        });
        recipe.setUuid(UUID.randomUUID());
        repository.save(recipe);
    }

    @Override
    public Page<Recipe> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    @Lock(LockModeType.OPTIMISTIC)
    @Override
    public void update(UUID uuid, LocalDateTime dateTimeUpdate, RecipeCreateDto recipeCreateDto) {
        Recipe recipe = repository.getReferenceById(uuid);
        mapper.map(recipeCreateDto, recipe);
        recipe.setDateTimeUpdate(dateTimeUpdate);
        repository.save(recipe);
    }
}
