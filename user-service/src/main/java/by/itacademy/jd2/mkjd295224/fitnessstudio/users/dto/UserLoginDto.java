package by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserLoginDto(
        @JsonProperty(value = "mail")
        String email,
        String password) {
}

/*
JSON user login object
{
        "email": "string",
        "password": "string"
        }
 */
