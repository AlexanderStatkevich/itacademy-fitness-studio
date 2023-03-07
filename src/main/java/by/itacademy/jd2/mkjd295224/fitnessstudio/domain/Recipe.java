package by.itacademy.jd2.mkjd295224.fitnessstudio.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "recepies")
public class Recipe extends BaseEntityWithDateTime {
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "recipe")
    private List<RecipeComposition> composition;
}
