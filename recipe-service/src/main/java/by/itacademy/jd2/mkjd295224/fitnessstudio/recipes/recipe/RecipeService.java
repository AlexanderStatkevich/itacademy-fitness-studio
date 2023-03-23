package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Recipe;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeCompositionCreateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeCreateUpdateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.mapper.RecipeCompositionMapper;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.mapper.RecipeMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class RecipeService implements IRecipeService {

    public static final int ZONE_OFFSET = 3;
    private final IRecipeRepository repository;

    private final RecipeMapper mapper;

    private final RecipeCompositionMapper recipeCompositionMapper;

    public RecipeService(IRecipeRepository repository, RecipeMapper mapper, RecipeCompositionMapper recipeCompositionMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.recipeCompositionMapper = recipeCompositionMapper;
    }

    @Override
    public void create(RecipeCreateUpdateDto recipeCreateUpdateDto) {
        Recipe recipe = mapper.toEntity(recipeCreateUpdateDto);
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
    @Override
    public void update(UUID uuid, LocalDateTime dateTimeUpdate, RecipeCreateUpdateDto recipeCreateUpdateDto) {
        Recipe recipe = repository.getByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("recipe not found"));

        if (!recipe.getDateTimeUpdate().truncatedTo(ChronoUnit.MILLIS).equals(dateTimeUpdate.minusHours(ZONE_OFFSET))) {
            throw new OptimisticLockException("recipe with " + uuid + " has been modified");
        }
        recipe.setTitle(recipeCreateUpdateDto.title());
        for (RecipeCompositionCreateDto recipeCompositionCreateDto : recipeCreateUpdateDto.composition()) {
            recipe.getComposition().stream()
                    .filter(recipeComposition -> recipeComposition.getProduct().getUuid().equals(recipeCompositionCreateDto.product()))
                    .findAny().ifPresentOrElse(recipeComposition -> recipeCompositionMapper.map(recipeCompositionCreateDto, recipeComposition),
                            () -> {
                                throw new EntityNotFoundException("composition not found");
                            });
        }
        recipe.setDateTimeUpdate(dateTimeUpdate);
        repository.save(recipe);
    }
}
