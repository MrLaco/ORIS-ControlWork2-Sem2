package ru.kpfu.itis.terletskiy.weatherspringboot.controller;

import javax.security.auth.message.*;
import lombok.*;
import org.apache.coyote.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.dto.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.service.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) throws AuthException {
        final JwtResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("sign_up")
    public ResponseEntity<CreateUserResponseDto> registerUser(@RequestBody CreateUserRequestDto user) {
        CreateUserResponseDto responseDto = authService.registerUser(user);
        return ResponseEntity.ok(responseDto);
    }
}
