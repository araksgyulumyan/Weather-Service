package com.example.weather.service;

import com.example.weather.entity.Weather;

import java.util.List;

public interface WeatherService {

    Weather createWeatherData(final String country, final String type);

    List<Weather> getAllWeatherData();

    void removeAllWeatherData();
}
