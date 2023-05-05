package ru.kpfu.itis.terletskiy.weatherspringboot.dto.user;

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
}