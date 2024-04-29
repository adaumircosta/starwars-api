package br.com.starwars.api.resource.dto;

import br.com.starwars.api.domain.Film;
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
public class PersonResponseDto {

    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private PlanetResponseDto homeworld;
    List<Film> films;
    List<SpeciesResponseDto> species;
    List<VehicleResponseDto> vehicles;
    List<StarshipResponseDto> starships;
    private Instant created;
    private Instant edited;
    private String url;

}