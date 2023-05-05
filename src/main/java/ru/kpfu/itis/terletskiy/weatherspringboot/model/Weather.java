package ru.kpfu.itis.terletskiy.weatherspringboot.model;

import lombok.*;

import javax.persistence.*;
import java.time.*;

@Entity(name = "weather_history")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "weather_data")
    private String weatherData;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

//    @ManyToOne(optional = false)
//    private User user;
}
