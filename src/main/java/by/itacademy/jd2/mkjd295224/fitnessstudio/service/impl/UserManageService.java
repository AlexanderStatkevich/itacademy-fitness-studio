package by.itacademy.jd2.mkjd295224.fitnessstudio.service.impl;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.repository.IUserManageRepository;
import by.itacademy.jd2.mkjd295224.fitnessstudio.service.api.IUserManageService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserManageService implements IUserManageService {

    private final IUserManageRepository repository;

    public UserManageService(IUserManageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public List<UserDto> findAll() {
        repository.findAll();
        return List.of(new UserDto());
    }

    @Override
    public UserDto findById(UUID uuid) {
        Optional<User> byId = repository.findById(uuid);
        //todo handle exception
        return new UserDto();
    }

    @Override
    public void update(UUID uuid, LocalDateTime dtUpdate, UserDto userDto) {
        User user = new User();
        repository.save(user);
    }
}
