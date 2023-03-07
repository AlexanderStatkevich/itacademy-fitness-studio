package by.itacademy.jd2.mkjd295224.fitnessstudio.web.controller.product;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.Recipe;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.recipe.RecipeCreateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.recipe.RecipeDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.mapper.RecipeMapper;
import by.itacademy.jd2.mkjd295224.fitnessstudio.service.product.IRecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody RecipeCreateDto recipeCreateDto) {
        recipeService.create(recipeCreateDto);
    }

    @GetMapping
    public Page<RecipeDto> getPage(Pageable pageable) {
        Page<Recipe> recipePage = recipeService.findAll(pageable);
        return recipePage.map(mapper::toDto);
    }

    @PutMapping(path = "/{uuid}/dt_update/{dt_update}")
    public void update(@PathVariable("uuid") UUID uuid,
                       @PathVariable("dt_update") LocalDateTime dtUpdate,
                       @RequestBody RecipeCreateDto recipeCreateDto) {
        recipeService.update(uuid, dtUpdate, recipeCreateDto);
    }
}
