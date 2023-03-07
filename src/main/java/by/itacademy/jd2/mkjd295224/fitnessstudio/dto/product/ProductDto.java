package by.itacademy.jd2.mkjd295224.fitnessstudio.dto.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductDto(
        UUID uuid,
        LocalDateTime dateCreate,
        LocalDateTime dateUpdate,
        String title,
        BigDecimal weight,
        BigDecimal calories,
        BigDecimal proteins,
        BigDecimal fats,
        BigDecimal carbohydrates
) {
}

/*
JSON product return object
      "uuid": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
      "dt_create": 0,
      "dt_update": 0,
      "title": "Гречка",
      "weight": 100,
      "calories": 308,
      "proteins": 12.6,
      "fats": 3.3,
      "carbohydrates": 57.1
 */
