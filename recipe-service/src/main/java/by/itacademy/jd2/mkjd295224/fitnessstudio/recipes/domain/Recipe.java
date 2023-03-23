package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "recipes")
public class Recipe extends BaseEntityWithDateTime {
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeComposition> composition;

    public Recipe() {
    }

    public Recipe(String title, List<RecipeComposition> composition) {
        this.title = title;
        this.composition = composition;
    }

    public Recipe(UUID uuid, LocalDateTime dateTimeUpdate, String title, List<RecipeComposition> composition) {
        super(uuid, dateTimeUpdate);
        this.title = title;
        this.composition = composition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RecipeComposition> getComposition() {
        return composition;
    }

    public void setComposition(List<RecipeComposition> composition) {
        this.composition = composition;
    }

    public BigDecimal getWeight() {
        return composition.stream()
                .map(RecipeComposition::getWeight)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getCalories() {
        return composition.stream()
                .map(RecipeComposition::getCalories)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getProteins() {
        return composition.stream()
                .map(RecipeComposition::getProteins)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getFats() {
        return composition.stream()
                .map(RecipeComposition::getFats)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getCarbohydrates() {
        return composition.stream()
                .map(RecipeComposition::getCarbohydrates)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
