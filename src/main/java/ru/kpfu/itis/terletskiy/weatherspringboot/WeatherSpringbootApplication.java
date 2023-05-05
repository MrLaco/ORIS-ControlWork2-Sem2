package ru.kpfu.itis.terletskiy.weatherspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.*;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.*;

@SpringBootApplication(scanBasePackages = {
        "ru.kpfu.itis.terletskiy.weatherspringboot.model",
        "ru.kpfu.itis.terletskiy.weatherspringboot.repository"})
@EnableJpaRepositories(basePackages = "ru.kpfu.itis.terletskiy.weatherspringboot.model")
public class WeatherSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherSpringbootApplication.class, args);
    }

}
