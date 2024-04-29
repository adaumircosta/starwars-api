package br.com.starwars.api.external.gateway.swapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmClientResponseDto extends SWApiClientReponseDto<FilmDetailClientResponseDto> {

    private List<FilmDetailClientResponseDto> results;

}