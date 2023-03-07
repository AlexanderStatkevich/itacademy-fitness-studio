package by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.UserRole;
import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UserCreateDto(
        String mail,
        @JsonProperty(value = "fio")
        String fullName,
        UserRole role,
        UserStatus status,
        String password
) {
}

/*
JSON user create and update object
{
        "mail": "string",
        "fio": "string",
        "role": "ADMIN",
        "status": "WAITING_ACTIVATION",
        "password": "string"
        }
 */
