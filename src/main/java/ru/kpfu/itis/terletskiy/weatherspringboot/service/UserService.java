package ru.kpfu.itis.terletskiy.weatherspringboot.service;

import ru.kpfu.itis.terletskiy.weatherspringboot.dto.user.*;

public interface UserService {

    CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto);
}
