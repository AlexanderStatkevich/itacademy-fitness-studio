package by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.UserRole;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.UserStatus;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.serialization.UnixSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDto(
        UUID uuid,
        @JsonProperty(value = "dt_create")
        @JsonSerialize(using = UnixSerializer.class)
        LocalDateTime dateTimeCreate,
        @JsonProperty(value = "dt_update")
        @JsonSerialize(using = UnixSerializer.class)
        LocalDateTime dateTimeUpdate,
        @JsonProperty(value = "mail")
        String email,
        @JsonProperty(value = "fio")
        String fullName,
        UserRole role,
        UserStatus status
) {
}
