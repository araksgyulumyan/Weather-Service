package com.example.weather.service.impl;

import com.example.weather.entity.Weather;
import com.example.weather.repository.WeatherRepository;
import com.example.weather.service.WeatherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    @Transactional
    public Weather createWeatherData(final String country, final String type) {
        assertCountry(country);
        assertType(type);
        Weather weather = new Weather();
        weather.setCountry(country);
        weather.setType(type);
        return weatherRepository.save(weather);
    }

    @Override
    public List<Weather> getAllWeatherData() {
        return weatherRepository.findAll();
    }

    @Override
    public void removeAllWeatherData() {
        weatherRepository.deleteAll();
    }


    private void assertType(final String type) {
        Assert.hasText(type, "Type should not be null");
    }

    private void assertCountry(final String country) {
        Assert.hasText(country, "Country name should not be null");
    }
}
