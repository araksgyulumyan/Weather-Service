package com.example.weather.exception;

public class WeatherNotFoundException extends RuntimeException {

    public WeatherNotFoundException(Long id) {
        super("Weather with id = " + id + " is not found");
    }
}
