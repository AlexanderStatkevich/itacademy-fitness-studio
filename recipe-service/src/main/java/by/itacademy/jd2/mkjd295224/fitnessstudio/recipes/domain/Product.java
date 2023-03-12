package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product extends BaseEntityWithDateTime {
    @Column(name = "title")
    private String title;
    @Column(name = "weight")
    private BigDecimal weight;
    @Column(name = "calories")
    private BigDecimal calories;
    @Column(name = "proteins")
    private BigDecimal proteins;
    @Column(name = "fats")
    private BigDecimal fats;
    @Column(name = "carbohydrates")
    private BigDecimal carbohydrates;

    public Product() {
    }

    public Product(UUID uuid,
                   LocalDateTime dateTimeUpdate,
                   String title, BigDecimal weight,
                   BigDecimal calories, BigDecimal proteins,
                   BigDecimal fats,
                   BigDecimal carbohydrates) {
        super(uuid, dateTimeUpdate);
        this.title = title;
        this.weight = weight;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getCalories() {
        return calories;
    }

    public void setCalories(BigDecimal calories) {
        this.calories = calories;
    }

    public BigDecimal getProteins() {
        return proteins;
    }

    public void setProteins(BigDecimal proteins) {
        this.proteins = proteins;
    }

    public BigDecimal getFats() {
        return fats;
    }

    public void setFats(BigDecimal fats) {
        this.fats = fats;
    }

    public BigDecimal getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(BigDecimal carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(title, product.title) && Objects.equals(weight, product.weight) && Objects.equals(calories, product.calories) && Objects.equals(proteins, product.proteins) && Objects.equals(fats, product.fats) && Objects.equals(carbohydrates, product.carbohydrates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, weight, calories, proteins, fats, carbohydrates);
    }

    public static final class ProductBuilder {
        private UUID uuid;
        private LocalDateTime dateTimeCreate;
        private LocalDateTime dateTimeUpdate;
        private String title;
        private BigDecimal weight;
        private BigDecimal calories;
        private BigDecimal proteins;
        private BigDecimal fats;
        private BigDecimal carbohydrates;

        private ProductBuilder() {
        }

        public ProductBuilder withUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public ProductBuilder withDateTimeCreate(LocalDateTime dateTimeCreate) {
            this.dateTimeCreate = dateTimeCreate;
            return this;
        }

        public ProductBuilder withDateTimeUpdate(LocalDateTime dateTimeUpdate) {
            this.dateTimeUpdate = dateTimeUpdate;
            return this;
        }

        public ProductBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ProductBuilder withWeight(BigDecimal weight) {
            this.weight = weight;
            return this;
        }

        public ProductBuilder withCalories(BigDecimal calories) {
            this.calories = calories;
            return this;
        }

        public ProductBuilder withProteins(BigDecimal proteins) {
            this.proteins = proteins;
            return this;
        }

        public ProductBuilder withFats(BigDecimal fats) {
            this.fats = fats;
            return this;
        }

        public ProductBuilder withCarbohydrates(BigDecimal carbohydrates) {
            this.carbohydrates = carbohydrates;
            return this;
        }

        public Product build() {
            return new Product(uuid, dateTimeUpdate, title, weight, calories, proteins, fats, carbohydrates);
        }
    }
}
