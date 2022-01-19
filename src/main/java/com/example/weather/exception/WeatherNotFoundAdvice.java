package com.example.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WeatherNotFoundAdvice {

    //todo revisit together
    @ResponseBody
    @ExceptionHandler(WeatherNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String weatherNotNullHandler(WeatherNotFoundException exception) {
        return exception.getMessage();
    }
}
