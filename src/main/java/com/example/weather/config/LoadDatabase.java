package com.example.weather.config;

import com.example.weather.entity.Weather;
import com.example.weather.repository.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    //todo write insert scripts into database.sql
//    @Bean
//    CommandLineRunner initDatabase(WeatherRepository weatherRepository) {
//        return args -> {
//            log.info("Preloading " + weatherRepository.save(new Weather("Armenia", "type1")));
//            log.info("Preloading " + weatherRepository.save(new Weather("Russia", "type2")));
//            log.info("Preloading " + weatherRepository.save(new Weather("UAE", "type3")));
//        };
//    }
}
