package com.example.weather.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class WeatherDto {

    @NotNull(message = "Country should not be null")
    private String country;

    @NotNull(message = "Type should not be null")
    private String type;

}
