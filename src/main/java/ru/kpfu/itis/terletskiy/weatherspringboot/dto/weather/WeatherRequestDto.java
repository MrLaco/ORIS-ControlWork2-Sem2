package ru.kpfu.itis.terletskiy.weatherspringboot.dto.weather;

import lombok.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.model.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.*;

@Data
@Builder
public class WeatherRequestDto {

    @NotBlank(message = "City name shouldn't be blank")
    private String cityName;
}