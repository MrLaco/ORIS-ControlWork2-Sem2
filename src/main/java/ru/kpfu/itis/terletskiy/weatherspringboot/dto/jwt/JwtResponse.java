package ru.kpfu.itis.terletskiy.weatherspringboot.dto.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtResponse {

    // Объект, который возвращаем в ответ

    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;

}