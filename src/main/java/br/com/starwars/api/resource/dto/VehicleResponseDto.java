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
public class VehicleResponseDto {

    private Integer id;
    private String name;
    private String model;
    private String manufacturer;
    private String costInCredits;
    private String length;
    private String maxAtmosphericSpeed;
    private Integer crew;
    private String passengers;
    private String cargoCapacity;
    private String consumables;
    private String vehicleClass;
    private String url;
    private Instant created;
    private Instant edited;

}