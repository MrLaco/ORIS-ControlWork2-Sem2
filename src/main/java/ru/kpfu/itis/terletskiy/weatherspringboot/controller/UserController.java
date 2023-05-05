package ru.kpfu.itis.terletskiy.weatherspringboot.controller;

import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.dto.user.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.service.*;

@RestController
@RequestMapping("/api/user/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("sign_up")
    public ResponseEntity<CreateUserResponseDto> createUser(@RequestBody CreateUserRequestDto user) {
        CreateUserResponseDto responseDto = userService.createUser(user);

        return ResponseEntity.ok(responseDto);
    }
}
