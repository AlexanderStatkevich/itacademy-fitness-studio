package by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user;

public record UserRegistrationDto(
        String mail,
        String fullName,
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
