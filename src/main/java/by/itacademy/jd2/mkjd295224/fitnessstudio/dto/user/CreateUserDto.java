package by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.UserRole;
import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.UserStatus;

public record CreateUserDto(
        String mail,
        String fullName,
        UserRole role,
        UserStatus status,
        String password
) {
}
