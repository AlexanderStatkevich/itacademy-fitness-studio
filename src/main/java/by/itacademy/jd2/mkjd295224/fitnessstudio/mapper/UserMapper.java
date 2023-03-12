package by.itacademy.jd2.mkjd295224.fitnessstudio.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user.UserCreateDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    User toEntity(UserCreateDto source);

    UserDto toDto(User source);

    void map(UserCreateDto source, @MappingTarget User target);
}
