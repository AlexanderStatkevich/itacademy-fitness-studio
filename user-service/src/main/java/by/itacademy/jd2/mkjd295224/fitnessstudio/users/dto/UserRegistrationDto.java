package by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRegistrationDto(
        @NotBlank
        String mail,
        @NotBlank
        String fullName,
        @NotBlank
        String password) {
}

/*
JSON user register object
{
        "mail":"string",
        "fio":"string",
        "password":"string"
        }
 */
