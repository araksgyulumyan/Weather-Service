package com.example.weather.service.impl;

import com.example.weather.entity.Weather;
import com.example.weather.exception.WeatherNotFoundException;
import com.example.weather.repository.WeatherRepository;
import com.example.weather.service.WeatherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

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
    @Transactional(readOnly = true)
    public List<Weather> getAllWeatherData() {
        return weatherRepository.findAll();
    }

    @Override
    @Transactional
    public void removeWeatherById(Long id) {
        Weather weatherById = getWeatherById(id);
        weatherRepository.delete(weatherById);
    }

    @Override
    public Weather getWeatherById(Long id) {
        return weatherRepository.findById(id).orElseThrow(() -> new WeatherNotFoundException(id));
    }

    private boolean assertWeather(Weather weather) {
        return Objects.isNull(weather.getCountry()) && Objects.isNull(weather.getType());
    }

    private void assertCountry(final String country) {
        Assert.hasText(country, "Country should not be empty");
    }

    private void assertType(final String type) {
        Assert.hasText(type, "Type should not be empty");
    }

}
