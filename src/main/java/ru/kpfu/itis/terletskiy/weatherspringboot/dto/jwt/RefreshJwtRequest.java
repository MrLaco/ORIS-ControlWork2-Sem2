package ru.kpfu.itis.terletskiy.weatherspringboot.dto.jwt;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RefreshJwtRequest {

    public String refreshToken;
}