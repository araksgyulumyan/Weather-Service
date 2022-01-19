package com.example.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.weather.repository")
public class WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }
}


//This must be added if we are NOT writing RESTful API, and we are writing app which is run  by MAIN

//@Component
//class Runner implements CommandLineRunner {
//
//    private final WeatherService weatherService;
//
//    public Runner(WeatherService weatherService) {
//        this.weatherService = weatherService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 0; i < 4; i++) {
//            weatherService.createWeatherData(new Weather());
//        }
//    }
//
//
//}
