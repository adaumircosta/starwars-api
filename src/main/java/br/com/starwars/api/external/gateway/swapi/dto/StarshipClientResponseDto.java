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
public class StarshipClientResponseDto extends SWApiClientReponseDto<StarshipDetailClientResponseDto> {

    private List<StarshipDetailClientResponseDto> results;
}
