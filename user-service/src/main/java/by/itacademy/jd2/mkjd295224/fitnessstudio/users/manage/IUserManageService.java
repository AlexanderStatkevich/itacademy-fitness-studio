package by.itacademy.jd2.mkjd295224.fitnessstudio.users.manage;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IUserManageService {
    void create(UserCreateDto userCreateDto);

    Page<User> findAll(Pageable pageable);

    User findById(UUID uuid);

    void update(UUID uuid, LocalDateTime dateTimeUpdate, UserCreateDto userCreateDto);
}
