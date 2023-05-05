package ru.kpfu.itis.terletskiy.weatherspringboot.dto.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.dto.user.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.model.*;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    CreateUserResponseDto userToUserResponseDto(User user);
}
