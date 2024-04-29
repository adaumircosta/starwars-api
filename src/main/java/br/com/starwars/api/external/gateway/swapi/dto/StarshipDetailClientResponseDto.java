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
public class StarshipDetailClientResponseDto {

    private String name;
    private String model;
    private String manufacturer;
    @JsonProperty("cost_in_credits")
    private String costInCredits;
    private String length;
    @JsonProperty("max_atmosphering_speed")
    private String maxAtmosphericSpeed;
    private String crew;
    private String passengers;
    @JsonProperty("cargo_capacity")
    private String cargoCapacity;
    private String consumables;
    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;
    @JsonProperty("MGLT")
    private String mglt;
    @JsonProperty("starship_class")
    private String starshipClass;
    List<String> pilots;
    List<String> films;
    private Instant created;
    private Instant edited;
    private String url;
}
