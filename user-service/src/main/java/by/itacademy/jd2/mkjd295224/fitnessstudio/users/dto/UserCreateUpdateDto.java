package by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.UserRole;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UserCreateUpdateDto(
        @JsonProperty(value = "mail")
        String email,
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
        "email": "string",
        "fio": "string",
        "role": "ADMIN",
        "status": "WAITING_ACTIVATION",
        "password": "string"
        }
 */
