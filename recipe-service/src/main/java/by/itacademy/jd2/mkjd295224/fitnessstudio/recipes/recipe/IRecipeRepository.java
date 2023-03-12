package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IRecipeRepository extends JpaRepository<Recipe, UUID> {
}
