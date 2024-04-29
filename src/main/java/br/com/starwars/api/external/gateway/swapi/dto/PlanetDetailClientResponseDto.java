package br.com.starwars.api.external.gateway.swapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PlanetDetailClientResponseDto {

    private String name;
    @JsonProperty("rotation_period")
    private String rotationPeriod;
    @JsonProperty("orbital_period")
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    @JsonProperty("surface_water")
    private String surfaceWater;
    private String population;
    List<String> residents;
    List<String> films;
    private Instant created;
    private Instant edited;
    private String url;

}