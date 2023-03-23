package by.itacademy.jd2.mkjd295224.fitnessstudio.users.account;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.account.mailing.dto.EmailVerificationDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserLoginDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserRegistrationDto;

public interface IUserAccountService {
    void register(UserRegistrationDto userRegistrationDto);

    boolean verify(EmailVerificationDto emailVerificationDto);

    String login(UserLoginDto userLoginDto);

    UserDto getInfo();
}
