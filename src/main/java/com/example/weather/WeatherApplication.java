package com.example.weather;

import com.example.weather.service.WeatherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.weather")

public class WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }


}

@Component
class Runner implements CommandLineRunner {


    private final WeatherService weatherService;

    public Runner(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public void run(String... args) throws Exception {
        weatherService.createWeatherData("Armenia", "type");
        final var all = weatherService.getAllWeatherData();
        all.forEach(System.out::println);
    }
}
