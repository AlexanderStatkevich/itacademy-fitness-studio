package by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.UserRole;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.UserStatus;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.validation.UniqueEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserCreateUpdateDto(
        @NotBlank
        @UniqueEntity
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
        @JsonProperty(value = "mail")
        String email,
        @NotBlank
        @JsonProperty(value = "fio")
        String fullName,
        @NotBlank
        UserRole role,
        @NotBlank
        UserStatus status,
        @NotBlank
        String password
) {
}
