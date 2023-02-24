package by.itacademy.jd2.mkjd295224.fitnessstudio.repository;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IRecipeRepository extends JpaRepository<Recipe, UUID> {
}
