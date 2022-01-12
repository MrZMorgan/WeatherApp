package com.dbeaver.weather_app.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/** Сущность таблицы weather_history. */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weather_history")
@Entity
public class Weather {

    /** Идентификатор сущности. */
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Дата для которой получена погода. */
    @Column(name = "weather_date")
    private Date weatherData;

    /** Температура. */
    @Column(name = "weather_value")
    private String weatherValue;

    /** Статический метод для создания сущности weather_history для записи в таблицу. */
    public static Weather of(
        @NonNull final Date weatherData,
        @NonNull final String weatherValue)
    {
        final Weather weather = new Weather();
        weather.setWeatherData(weatherData);
        weather.setWeatherValue(weatherValue);
        return weather;
    }
}
