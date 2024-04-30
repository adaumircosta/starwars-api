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
public class PlanetResponseDto {

    private Integer id;
    private String name;
    private String rotationPeriod;
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surfaceWater;
    private String population;
    private Instant created;
    private Instant edited;
    private String url;

}