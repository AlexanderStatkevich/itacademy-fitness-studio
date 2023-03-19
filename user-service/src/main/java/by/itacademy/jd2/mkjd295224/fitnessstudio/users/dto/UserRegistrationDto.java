package by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationDto(
        @NotBlank
        @JsonProperty(value = "mail")
        String email,
        @NotBlank
        @JsonProperty(value = "fio")
        String fullName,
        @NotBlank
        String password) {
}

/*
JSON user register object
{
        "email":"new",
        "fio":"kwjefjowef",
        "password":"string"
        }
 */
