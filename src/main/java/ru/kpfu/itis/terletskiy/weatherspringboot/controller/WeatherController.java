package ru.kpfu.itis.terletskiy.weatherspringboot.controller;

import lombok.*;
import org.springframework.boot.autoconfigure.security.oauth2.resource.*;
import org.springframework.http.*;
import org.springframework.security.oauth2.server.resource.authentication.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.config.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.dto.weather.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.service.*;

import javax.servlet.http.*;

@RestController
@RequestMapping("/api/weather")
@AllArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;
    private final JwtProvider jwtProvider;

    @GetMapping("/get")
    public ResponseEntity<WeatherResponseDto> getWeatherInCity(
            @RequestParam String cityName,
            HttpServletRequest request
    ) {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        String token = getTokenFromRequest(request);
        if (token != null && jwtProvider.validateAccessToken(token)) {
            WeatherResponseDto weatherResponseDto = weatherService.getWeatherInCity(cityName);
            return ResponseEntity.ok(weatherResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String bearer = request.getHeader("Authorization");
        if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring("Bearer ".length());
        }
        return null;
    }
}
