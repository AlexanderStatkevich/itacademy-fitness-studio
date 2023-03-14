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
        String mail,
        String fullName,
        UserRole role,
        UserStatus status
) {
}

//JSON user return info object
//{
//  "uuid": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
//  "dt_create": 0,
//  "dt_update": 0,
//  "mail": "string",
//  "fio": "string",
//  "role": "ADMIN",
//  "status": "WAITING_ACTIVATION"
//}

