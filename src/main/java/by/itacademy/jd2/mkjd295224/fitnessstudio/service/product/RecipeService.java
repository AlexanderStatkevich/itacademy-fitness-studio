package by.itacademy.jd2.mkjd295224.fitnessstudio.service.product;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.Recipe;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.recipe.RecipeCreateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.mapper.RecipeMapper;
import by.itacademy.jd2.mkjd295224.fitnessstudio.repository.IRecipeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        repository.save(recipe);
    }

    @Override
    public Page<Recipe> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void update(UUID uuid, LocalDateTime dateTimeUpdate, RecipeCreateDto recipeCreateDto) {
        Recipe recipe = repository.getReferenceById(uuid);
        mapper.map(recipeCreateDto, recipe);
        recipe.setDateTimeUpdate(dateTimeUpdate);
        repository.save(recipe);
    }
}
