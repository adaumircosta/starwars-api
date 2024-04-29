package br.com.starwars.api.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmResponseDto {

    private String title;
    private Integer episodeId;
    private String openingCrawl;
    private String director;
    private String producer;
    private LocalDate releaseDate;
    private List<PersonResponseDto> characters;
    private List<PlanetResponseDto> planets;
    private List<StarshipResponseDto> starships;
    private List<VehicleResponseDto> vehicles;
    private List<SpeciesResponseDto> species;
    private Instant created;
    private Instant edited;
    private String url;
    private Integer version;
}
