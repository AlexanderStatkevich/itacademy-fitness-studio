package by.itacademy.jd2.mkjd295224.fitnessstudio.users.manage;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserCreateUpdateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserManageService implements IUserManageService {

    private final IUserManageRepository repository;
    private final UserMapper mapper;

    public UserManageService(IUserManageRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(UserCreateUpdateDto userCreateUpdateDto) {
        User user = mapper.toEntity(userCreateUpdateDto);
        repository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public User findById(UUID uuid) {
        return repository.getReferenceById(uuid);
    }

    @Override
    public void update(UUID uuid, LocalDateTime dateTimeUpdate, UserCreateUpdateDto userCreateUpdateDto) {
        User user = repository.getReferenceById(uuid);
        mapper.map(userCreateUpdateDto, user);
        user.setDateTimeUpdate(dateTimeUpdate);
        repository.save(user);
    }
}
