package by.itacademy.jd2.mkjd295224.fitnessstudio.service.api;

import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.UserDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IUserManageService {
    void create(UserDto userDto);

    List<UserDto> findAll();

    UserDto findById(UUID uuid);

    void update(UUID uuid, LocalDateTime dtUpdate, UserDto userDto);
}
