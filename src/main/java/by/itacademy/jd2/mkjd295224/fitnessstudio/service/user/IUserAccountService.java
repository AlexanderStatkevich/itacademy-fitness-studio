package by.itacademy.jd2.mkjd295224.fitnessstudio.service.user;

import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user.UserLoginDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user.UserRegistrationDto;

public interface IUserAccountService {
    void register(UserRegistrationDto userRegistrationDto);

    boolean verify();

    void login(UserLoginDto userLoginDto);

    UserDto getInfo();
}
