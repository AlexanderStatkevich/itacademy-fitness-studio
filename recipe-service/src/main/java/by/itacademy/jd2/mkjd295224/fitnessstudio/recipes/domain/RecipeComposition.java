package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "recipe_compositions")
public class RecipeComposition extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "weight")
    private BigDecimal weight;

    public RecipeComposition() {
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getCalories() {
        return weight
                .divide(product.getWeight(), RoundingMode.HALF_UP)
                .multiply(product.getCalories())
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getProteins() {
        return weight
                .divide(product.getWeight(), RoundingMode.HALF_UP)
                .multiply(product.getProteins())
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getFats() {
        return weight
                .divide(product.getWeight(), RoundingMode.HALF_UP)
                .multiply(product.getFats())
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getCarbohydrates() {
        return weight
                .divide(product.getWeight(), RoundingMode.HALF_UP)
                .multiply(product.getCarbohydrates())
                .setScale(2, RoundingMode.HALF_UP);
    }
}
