package by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.UserRole;
import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDto(
        UUID uuid,
        @JsonProperty(value = "dt_create")
        LocalDateTime dateTimeCreate,
        @JsonProperty(value = "dt_update")
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

