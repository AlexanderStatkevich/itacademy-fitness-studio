package by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto;

import java.util.Map;

public record EmailDto(
        String email,
        Map<String, Object> templateModel
) {
}
