package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Recipe;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeCreateUpdateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.RecipeDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto.mapper.RecipeMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    private final IRecipeService recipeService;

    private final RecipeMapper mapper;

    public RecipeController(IRecipeService recipeService, RecipeMapper mapper) {
        this.recipeService = recipeService;
        this.mapper = mapper;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody RecipeCreateUpdateDto recipeCreateUpdateDto) {
        recipeService.create(recipeCreateUpdateDto);
    }


    @GetMapping
    public Page<RecipeDto> getPage(Pageable pageable) {
        Page<Recipe> recipePage = recipeService.findAll(pageable);
        return recipePage.map(mapper::toDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(path = "/{uuid}/dt_update/{dt_update}")
    public void update(@PathVariable("uuid") UUID uuid,
                       @PathVariable("dt_update") LocalDateTime dtUpdate,
                       @RequestBody RecipeCreateUpdateDto recipeCreateUpdateDto) {
        recipeService.update(uuid, dtUpdate, recipeCreateUpdateDto);
    }
}
