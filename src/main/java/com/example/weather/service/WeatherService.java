package com.example.weather.service;

import com.example.weather.entity.Weather;

import java.util.List;

//todo add java docs
public interface WeatherService {

    /**
     * Creates weather data
     * @param country
     * @param type
     * @return
     */
    Weather createWeatherData(final String country, final String type);

    /**
     * Returns all weathers
     * @return
     */
    List<Weather> getAllWeatherData();

    /**
     * Removes weather with specified id
     * @param id
     */
    void removeWeatherById(final Long id);

    /**
     * Returnes weather by specified id
     * @param id
     * @return
     */
    Weather getWeatherById(final Long id);
}
