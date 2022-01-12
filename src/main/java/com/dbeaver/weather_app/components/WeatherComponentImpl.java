package com.dbeaver.weather_app.components;

import com.dbeaver.weather_app.entities.Weather;
import com.dbeaver.weather_app.repositories.WeatherRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/** Компонент для работы с таблицей weather_history. */
@Component
@RequiredArgsConstructor
public class WeatherComponentImpl implements WeatherComponent {

    /** Репозиторий таблицы weather_history. */
    private final WeatherRepository weatherRepository;

    @Override
    public Weather getWeatherByDate(@NonNull final Date date) {
        return this.weatherRepository.findByWeatherData(date);
    }

    @Override
    public Weather saveNewWeather(@NonNull final Weather weather) {
        return this.weatherRepository.save(weather);
    }
}
