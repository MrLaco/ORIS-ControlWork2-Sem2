package ru.kpfu.itis.terletskiy.weatherspringboot.service.impl;

import lombok.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.dto.mapper.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.dto.user.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.model.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.repository.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.service.*;

import java.util.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);

        User user = User.builder()
                .email(createUserRequestDto.getEmail())
                .name(createUserRequestDto.getName())
                .password(encoder.encode(createUserRequestDto.getPassword()))
                .roles(roles)
                .build();

        userRepository.save(user);

        return UserMapper.INSTANCE.userToUserResponseDto(user);
    }
}
