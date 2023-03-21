package by.itacademy.jd2.mkjd295224.fitnessstudio.users.account;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.account.mailing.dto.EmailVerificationDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserLoginDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserRegistrationDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserAccountController {

    private final IUserAccountService userAccountService;

    public UserAccountController(IUserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping(path = "/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody UserRegistrationDto userRegistrationDto) {
        userAccountService.register(userRegistrationDto);
    }

    @GetMapping(path = "/verification")
    @ResponseStatus(value = HttpStatus.OK)
    public void verify(EmailVerificationDto emailVerificationDto) {
        userAccountService.verify(emailVerificationDto);
    }

    @PostMapping(path = "/login")
    @ResponseStatus(value = HttpStatus.OK)
    public String login(@Valid @RequestBody UserLoginDto userLoginDto) {
        return userAccountService.login(userLoginDto);
    }

    @GetMapping(path = "/me")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDto getPersonalInfo() {
        return userAccountService.getInfo();
    }
}
