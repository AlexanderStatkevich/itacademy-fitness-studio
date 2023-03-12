package by.itacademy.jd2.mkjd295224.fitnessstudio.users.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserCreateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    User toEntity(UserCreateDto source);

    UserDto toDto(User source);

    void map(UserCreateDto source, @MappingTarget User target);
}
