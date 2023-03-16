package by.itacademy.jd2.mkjd295224.fitnessstudio.users.account;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.UserStatus;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.EmailVerificationDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserLoginDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService implements IUserAccountService {
    private final IUserAccountRepository repository;

    private final UserAccountClient userAccountClient;

    public UserAccountService(IUserAccountRepository repository, UserAccountClient userAccountClient) {
        this.repository = repository;
        this.userAccountClient = userAccountClient;
    }

    @Override
    public void register(UserRegistrationDto userRegistrationDto) {

    }

    @Override
    public boolean verify(EmailVerificationDto emailVerificationDto) {
        String email = emailVerificationDto.email();
        String code = emailVerificationDto.code();
        Boolean verify = userAccountClient.verify(email, code);
        if (verify) {
            User user = repository.findUserByEmail(email);
            user.setStatus(UserStatus.ACTIVATED);
            repository.save(user);
        }
        return verify;
    }

    @Override
    public void login(UserLoginDto userLoginDto) {

    }

    @Override
    public UserDto getInfo() {
        return null;
    }

    public User getUserByUsername() {
        return null;
    }
}
