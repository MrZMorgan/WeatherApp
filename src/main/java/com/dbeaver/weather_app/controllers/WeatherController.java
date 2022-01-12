package com.dbeaver.weather_app.controllers;

import com.dbeaver.weather_app.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Контоллер для работы с информацией о температуре. */
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class WeatherController {

    /** Сервис для работы с информацией о погоде. */
    private final WeatherService weatherService;

    /** Возвращает значение текущей температуры. */
    @GetMapping("weather")
    public final String getTodayWeather() {
        return this.weatherService.getTodayWeather();
    }
}
