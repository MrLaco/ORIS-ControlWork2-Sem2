package ru.kpfu.itis.terletskiy.weatherspringboot.dto.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.dto.weather.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.model.*;

@Mapper
public interface WeatherMapper {
    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    WeatherResponseDto weatherToWeatherResponseDto(Weather weatherHistory);
}
