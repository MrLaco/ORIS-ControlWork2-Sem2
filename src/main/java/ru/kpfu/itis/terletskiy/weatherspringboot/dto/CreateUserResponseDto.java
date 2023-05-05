package ru.kpfu.itis.terletskiy.weatherspringboot.dto;

import lombok.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.model.*;

import javax.validation.constraints.*;
import java.util.*;

@Data
@Builder
public class CreateUserResponseDto {

    private Integer id;

    private String name;

    private String email;

    private String password;

    private Set<Role> roles;

    public static CreateUserResponseDto fromUser(User user) {

        return CreateUserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}