package br.com.starwars.api.external.gateway.swapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanetClientResponseDto extends SWApiClientReponseDto<PlanetDetailClientResponseDto>{

    private Integer count;
    private String next;
    private String previous;
    private List<PlanetDetailClientResponseDto> results;

}