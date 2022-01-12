package com.dbeaver.weather_app.components;

import com.dbeaver.weather_app.entities.Weather;

import java.util.Date;

/** Интерфейс компонента для работы с таблицей weather_history. */
public interface WeatherComponent {

    /**
     * @param date дата для поиска записи.
     * @return значение погоды на заданную дату. */
    Weather getWeatherByDate(Date date);

    /**
     * @param weather данные о тепмпературе.
     * @return сохраняет новое значение температуры в базу.
     */
    Weather saveNewWeather(Weather weather);
}
