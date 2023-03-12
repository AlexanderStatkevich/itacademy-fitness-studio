package by.itacademy.jd2.mkjd295224.fitnessstudio.users.account;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserLoginDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserRegistrationDto;
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
