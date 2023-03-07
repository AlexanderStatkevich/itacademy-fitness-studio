package by.itacademy.jd2.mkjd295224.fitnessstudio.service.user;

import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user.UserLoginDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user.UserRegistrationDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.repository.IUserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService implements IUserAccountService {
    private final IUserAccountRepository repository;

    public UserAccountService(IUserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(UserRegistrationDto userRegistrationDto) {

    }

    @Override
    public boolean verify() {
        return false;
    }

    @Override
    public void login(UserLoginDto userLoginDto) {

    }

    @Override
    public UserDto getInfo() {
        return null;
    }
}
