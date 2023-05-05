package ru.kpfu.itis.terletskiy.weatherspringboot.dto.jwt;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtRequest {

    // Объект, который пользователь будет присылать, чтобы получить JWT токен

    private String email;
    private String password;
}