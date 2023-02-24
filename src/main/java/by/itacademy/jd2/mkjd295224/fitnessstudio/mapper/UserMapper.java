package by.itacademy.jd2.mkjd295224.fitnessstudio.mapper;

import by.itacademy.jd2.mkjd295224.fitnessstudio.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.dto.user.CreateUserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User toEntity(CreateUserDto source);
}
