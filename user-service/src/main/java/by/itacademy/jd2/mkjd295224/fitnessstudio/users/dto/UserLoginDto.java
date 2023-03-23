package by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserLoginDto(
        @NotBlank
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
        @JsonProperty(value = "mail")
        String email,
        @NotBlank
        String password) {
}
