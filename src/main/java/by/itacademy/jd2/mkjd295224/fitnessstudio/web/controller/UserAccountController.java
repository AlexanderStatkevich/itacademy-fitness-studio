package by.itacademy.jd2.mkjd295224.fitnessstudio.web.controller;

import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.service.api.IUserAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserAccountController {

    IUserAccountService userAccountService;

    @PostMapping(path = "/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserDto genre) {
        userAccountService.create(genre);
    }

    @GetMapping(path = "/verification")
    public List<UserDto> getList() {
        return userAccountService.getContent();
    }

    @PostMapping(path = "/login")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserDto genre) {
        userAccountService.create(genre);
    }

    @GetMapping(path = "/me")
    public List<UserDto> getList() {
        return userAccountService.getContent();
    }
}
