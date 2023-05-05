package ru.kpfu.itis.terletskiy.weatherspringboot.dto.user;

import lombok.*;

import javax.validation.constraints.*;

@Data
@Builder
public class CreateUserRequestDto {

    @NotBlank(message = "Name shouldn't be blank")
    private String name;

    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @Size(min = 8, max = 63, message = "Password should contain from 8 to 63 symbols")
    private String password;
}