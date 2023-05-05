package ru.kpfu.itis.terletskiy.weatherspringboot.dto.weather;

import ru.kpfu.itis.terletskiy.weatherspringboot.model.*;

import javax.persistence.*;
import java.time.*;

public class WeatherResponseDto {

    private String cityName;

    private String weatherData;

    private LocalDateTime createdAt;
}
