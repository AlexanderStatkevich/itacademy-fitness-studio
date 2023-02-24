package by.itacademy.jd2.mkjd295224.fitnessstudio.service.api;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user.UserDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IUserManageService {
    void create(User user);

    List<UserDto> findAll();

    UserDto findById(UUID uuid);

    void update(UUID uuid, LocalDateTime dtUpdate, UserDto userDto);
}
