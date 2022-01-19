package com.example.weather.controller;

import com.example.weather.dto.WeatherDto;
import com.example.weather.entity.Weather;
import com.example.weather.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/weathers")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Weather>> getAllWeatherData() {
        return new ResponseEntity<>(weatherService.getAllWeatherData(), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Weather> createWeather(@Valid @RequestBody WeatherDto weatherDto) {
        assertWeatherDto(weatherDto);
        return new ResponseEntity<>(weatherService.createWeatherData(weatherDto.getCountry(), weatherDto.getType()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Weather> getWeatherById(@PathVariable Long id) {
        return new ResponseEntity<>(weatherService.getWeatherById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> removeAllWeatherData(@PathVariable Long id) {
        weatherService.removeWeatherById(id);
        return new ResponseEntity<>("Weather Deleted Successfully", HttpStatus.OK);
    }

    private void assertWeatherDto(WeatherDto weatherDto) {
        Assert.notNull(weatherDto, "Weather Dto should not be null");
    }

}
