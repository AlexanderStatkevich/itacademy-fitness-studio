package by.itacademy.jd2.mkjd295224.fitnessstudio.users.account;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.EmailVerificationDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserLoginDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserRegistrationDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public void register(UserRegistrationDto userRegistrationDto) {
        userAccountService.register(userRegistrationDto);
    }

    @GetMapping(path = "/verification")
    public void verify(@Valid @RequestParam EmailVerificationDto emailVerificationDto) {
        userAccountService.verify(emailVerificationDto);
    }

    @PostMapping(path = "/login")
    //todo set response status or entity
    public void login(UserLoginDto userLoginDto) {
        userAccountService.login(userLoginDto);
    }

    @GetMapping(path = "/me")
    public void getPersonalInfo() {
        userAccountService.getInfo();
    }
}
