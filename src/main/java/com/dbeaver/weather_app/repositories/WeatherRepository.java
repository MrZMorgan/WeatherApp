package com.dbeaver.weather_app.repositories;

import com.dbeaver.weather_app.entities.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/** Репозиторий таблицы weather_history. */
@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    /**
     * @param date дата для поиска записи о температуре.
     * @return Ищет запись в таблице по дате.
     */
    Weather findByWeatherData(Date date);
}
