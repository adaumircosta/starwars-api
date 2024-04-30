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
public class Species {

    private Integer id;
    private String name;
    private String classification;
    private String designation;
    private String averageHeight;
    private String skinColors;
    private String hairColors;
    private String eyeColors;
    private String averageLifespan;
    private Planet homeworld;
    private String language;
    private Instant created;
    private Instant edited;
    private String url;

}