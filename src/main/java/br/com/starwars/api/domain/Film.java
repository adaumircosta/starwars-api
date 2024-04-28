package br.com.starwars.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Film extends SWApi{

    private String title;
    private Integer episodeId;
    private String openingCrawl;
    private String director;
    private String producer;
    private LocalDate releaseDate;
    private List<Person> characters;
    private List<Planet> planets;
    private List<Starship> starships;
    private List<Vehicle> vehicles;
    private List<Species> species;
    private Instant created;
    private Instant edited;
    private String url;

}