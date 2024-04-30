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
public class SpeciesResponseDto {

    private Integer id;
    private String name;
    private String classification;
    private String designation;
    private String averageHeight;
    private String skinColors;
    private String hairColors;
    private String eyeColors;
    private String averageLifespan;
    private PlanetResponseDto homeworld;
    private String language;
    private Instant created;
    private Instant edited;
    private String url;

}