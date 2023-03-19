package by.itacademy.jd2.mkjd295224.fitnessstudio.users.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserCreateUpdateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserRegistrationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    User toEntity(UserCreateUpdateDto source);

    @Mapping(target = "password", ignore = true)
    User toEntity(UserRegistrationDto source);

    UserDto toDto(User source);

    void map(UserCreateUpdateDto source, @MappingTarget User target);
}
