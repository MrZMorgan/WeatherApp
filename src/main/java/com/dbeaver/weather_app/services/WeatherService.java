package com.dbeaver.weather_app.services;

/** Интерфейс сервиса для работы с погодой. */
public interface WeatherService {

    /**
     * @return возвращает значение погоды на сегодняшний день если оно присутствует в базе.
     * Если нет - делает запрос на внешний сервис, сохраняет в базу и возвращает полученное значение.
     */
    String getTodayWeather();
}
