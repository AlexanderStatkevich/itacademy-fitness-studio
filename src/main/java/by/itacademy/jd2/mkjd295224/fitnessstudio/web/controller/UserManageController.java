package by.itacademy.jd2.mkjd295224.fitnessstudio.web.controller;

import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.service.api.IUserManageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserManageController {

    IUserManageService userManageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserDto userDto) {
        userManageService.create(userDto);
    }

    @GetMapping
    public List<UserDto> getList() {
        return userManageService.findAll();
    }

    @GetMapping(path = "/{uuid}")
    public UserDto getById(@RequestParam UUID uuid) {
        return userManageService.findById(uuid);
    }

    @PutMapping(path = "/{uuid}/dt_update/{dt_update}")
    public void update(@PathVariable("uuid") UUID uuid,
                       @PathVariable("dt_update") LocalDateTime dtUpdate,
                       @RequestBody UserDto userDto) {
        return userManageService.update(uuid, dtUpdate, userDto);
    }
}
