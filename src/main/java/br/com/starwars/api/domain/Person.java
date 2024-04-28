package br.com.starwars.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private Planet homeworld;
    List<Film> films;
    List<Species> species;
    List<Vehicle> vehicles;
    List<Starship> starships;
    private Instant created;
    private Instant edited;
    private String url;

}