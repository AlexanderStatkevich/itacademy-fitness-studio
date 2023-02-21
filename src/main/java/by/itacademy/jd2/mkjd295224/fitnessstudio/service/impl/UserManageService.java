package by.itacademy.jd2.mkjd295224.fitnessstudio.service.impl;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.service.api.IUserManageService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class UserManageService implements IUserManageService {

    IUserManageService repository;

    public UserManageService(IUserManageService repository) {
        this.repository = repository;
    }

    @Override
    public void create(UserDto userDto) {
        User user = new User();
        repository.create(user);
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll();
    }

    @Override
    public UserDto findById(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public void update(UUID uuid, LocalDateTime dtUpdate, UserDto userDto) {
        User user = new User();
        repository.update(user);
    }
}
