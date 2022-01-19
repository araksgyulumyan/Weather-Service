package com.example.weather.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "weather")
@NoArgsConstructor
@Getter
@Setter
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Country should not be null")
    private String country;

    @NotNull(message = "Type should not be null")
    private String type;

}
