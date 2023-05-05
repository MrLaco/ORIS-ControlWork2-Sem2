package ru.kpfu.itis.terletskiy.weatherspringboot.service;

import io.jsonwebtoken.*;
import javax.security.auth.message.*;
import lombok.*;
import org.springframework.security.core.context.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.stereotype.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.dto.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.filter.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.model.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.repository.*;


import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final Map<String, String> refreshStorage = new HashMap<>();
    private final JwtProvider jwtProvider;
    private final BCryptPasswordEncoder encoder;

    public JwtResponse login(JwtRequest authRequest) throws AuthException {
        final User user = userRepository.findUserByEmail(authRequest.getEmail())
                .orElseThrow(() -> new AuthException("User not found"));
        if (encoder.matches(authRequest.getPassword(), user.getPassword())) {
            final String accessToken = jwtProvider.generateAccessToken(user);
            final String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.getEmail(), refreshToken);
            return new JwtResponse(accessToken, refreshToken);
        } else {
            throw new AuthException("Incorrect password");
        }
    }

    public JwtResponse getAccessToken(@NonNull String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final User user = userRepository.findUserByEmail(login)
                        .orElseThrow(() -> new AuthException("User not found"));
                final String accessToken = jwtProvider.generateAccessToken(user);
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }

    public JwtResponse refresh(@NonNull String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final User user = userRepository.findUserByEmail(login)
                        .orElseThrow(() -> new AuthException("User not found"));
                final String accessToken = jwtProvider.generateAccessToken(user);
                final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                refreshStorage.put(user.getEmail(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            }
        }
        throw new AuthException("Invalid JWT token");
    }

    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }

    public CreateUserResponseDto registerUser(CreateUserRequestDto createUserRequestDto) {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);

        User user = User.builder()
                .email(createUserRequestDto.getEmail())
                .name(createUserRequestDto.getName())
                .password(encoder.encode(createUserRequestDto.getPassword()))
                .roles(roles)
                .build();

        userRepository.save(user);

        return CreateUserResponseDto.fromUser(user);
    }
}