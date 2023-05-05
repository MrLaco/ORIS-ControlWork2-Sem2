package ru.kpfu.itis.terletskiy.weatherspringboot.service.impl;

import lombok.*;
import org.springframework.stereotype.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.dto.mapper.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.dto.weather.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.model.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.repository.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.service.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.utils.*;

import java.time.*;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    @Override
    public WeatherResponseDto getWeatherInCity(String cityName) {
        String data = WeatherUtil.getWeatherInCity(cityName);

        Weather weather = Weather.builder()
                .cityName(cityName)
//                .weatherData(data)
                .createdAt(LocalDateTime.now())
//                .user()
                .build();
        weatherRepository.save(weather);

        return WeatherMapper.INSTANCE.weatherToWeatherResponseDto(weather);
    }
}
