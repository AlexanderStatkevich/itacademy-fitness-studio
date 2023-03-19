package by.itacademy.jd2.mkjd295224.fitnessstudio.users.manage;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserCreateUpdateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserManageController {

    private final IUserManageService userManageService;
    private final UserMapper mapper;

    public UserManageController(IUserManageService userManageService, UserMapper mapper) {
        this.userManageService = userManageService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserCreateUpdateDto userCreateUpdateDto) {
        userManageService.create(userCreateUpdateDto);
    }

    @GetMapping
    public Page<UserDto> getList(Pageable pageable) {
        Page<User> userPage = userManageService.findAll(pageable);
        return userPage.map(mapper::toDto);
    }

    @GetMapping(path = "/{uuid}")
    public UserDto getById(@PathVariable UUID uuid) {
        User user = userManageService.findById(uuid);
        return mapper.toDto(user);
    }

    @PutMapping(path = "/{uuid}/dt_update/{dt_update}")
    public void update(@PathVariable("uuid") UUID uuid,
                       @PathVariable("dt_update") LocalDateTime dateTimeUpdate,
                       @RequestBody UserCreateUpdateDto userCreateUpdateDto) {
        userManageService.update(uuid, dateTimeUpdate, userCreateUpdateDto);
    }
}
