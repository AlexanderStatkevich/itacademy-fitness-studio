package by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.recipe.dto;

import by.itacademy.jd2.mkjd295224.fitnessstudio.recipes.serialization.UnixSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JsonPropertyOrder({
        "uuid",
        "dt_create",
        "dt_update",
        "title",
        "composition",
        "weight",
        "calories",
        "proteins",
        "fats",
        "carbohydrates"
})
public record RecipeDto(
        UUID uuid,
        @JsonProperty(value = "dt_create")
        @JsonSerialize(using = UnixSerializer.class)
        LocalDateTime dateTimeCreate,
        @JsonProperty(value = "dt_update")
        @JsonSerialize(using = UnixSerializer.class)
        LocalDateTime dateTimeUpdate,
        String title,
        List<RecipeCompositionDto> composition,
        BigDecimal weight,
        BigDecimal calories,
        BigDecimal proteins,
        BigDecimal fats,
        BigDecimal carbohydrates
) {
}
