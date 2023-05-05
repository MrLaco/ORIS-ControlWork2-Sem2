package ru.kpfu.itis.terletskiy.weatherspringboot.utils;

import java.util.*;

public class WeatherUtil {

    public static String API_KEY = "ebd11e572ec0ab25b6b730cd911a0a6b";

    public static String getWeatherInCity(String cityName) {
        Map<String, String> getHeaders = new HashMap<>();

        Map<String, String> getParams = new HashMap<>();
        getParams.put("q", cityName);
        getParams.put("appid", API_KEY);

        return HttpRequestUtil.get("https://api.openweathermap.org/data/2.5/weather?", getHeaders, getParams);
    }
}
