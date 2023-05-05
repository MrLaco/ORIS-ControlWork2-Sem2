package ru.kpfu.itis.terletskiy.weatherspringboot.service;

import ru.kpfu.itis.terletskiy.weatherspringboot.dto.weather.*;

public interface WeatherService {

    WeatherResponseDto getWeatherInCity(String cityName);
}
