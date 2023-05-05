package ru.kpfu.itis.terletskiy.weatherspringboot.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import ru.kpfu.itis.terletskiy.weatherspringboot.model.*;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
