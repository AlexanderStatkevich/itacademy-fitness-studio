package by.itacademy.jd2.mkjd295224.fitnessstudio.web.controller;

import by.itacademy.jd2.mkjd295224.fitnessstudio.service.api.IUserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public void register() {
        userAccountService.register();
    }

    @GetMapping(path = "/verification")
    public void verify() {
        userAccountService.verify();
    }

    @PostMapping(path = "/login")
    @ResponseStatus(HttpStatus.CREATED)
    public void login() {
        userAccountService.login();
    }

    @GetMapping(path = "/me")
    public void getList() {
        userAccountService.getInfo();
    }
}
