package com.dbeaver.weather_app.services;

import com.dbeaver.weather_app.components.WeatherComponent;
import com.dbeaver.weather_app.entities.Weather;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

/** Сервиса для работы с погодой. */
@AllArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService {

    /** Компонент для работы с таблицей weather_history. */
    private final WeatherComponent weatherComponent;

    /** Компонент для выполнения HTTP запросов. */
    private final RestTemplateBuilder restTemplate;

    /** Адрес для получения значения температуры. */
    private final static String URL = "https://yandex.ru/";

    /** Открывающий тег внутри которого заключено значение температуры. */
    private final static String OPEN_TAG = "<div class='weather__temp'>";

    /** Закрывающий тег внутри которого заключено значение температуры. */
    private final static String CLOSE_TAG = "</div>";

    @Override
    public String getTodayWeather() {
        final var now = Timestamp.valueOf(LocalDateTime.now());

        return Objects.requireNonNullElseGet(
            weatherComponent.getWeatherByDate(now)
                .getWeatherValue(),
            () -> weatherComponent.saveNewWeather(Weather.of(now, getCurrentTemperature()))
                .getWeatherValue()
        );
    }

    /** Получает значение сегодняшней температуры из вшешнего сервиса. */
    private String getCurrentTemperature() {
        final var page = restTemplate.build().getForObject(URL, String.class);
        return StringUtils.substringBetween(page, OPEN_TAG, CLOSE_TAG);
    }
}
