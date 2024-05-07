package br.com.starwars.api.resource;

import br.com.starwars.api.interceptor.dto.ResponseError;
import br.com.starwars.api.resource.dto.FilmDetailResponseDto;
import br.com.starwars.api.resource.dto.FilmResponseDto;
import br.com.starwars.api.resource.dto.UpdateFilmRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "API STAR WARS", description = "API desenvolvida para desafio backend")
public interface SWApiController {

    @Operation(summary = "Retorna todo os filmes da saga", description = "Devolve uma lista de todos os filmes da saga de forma minimalista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso", content = @Content(schema = @Schema(implementation = FilmResponseDto.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
    ResponseEntity<List<FilmResponseDto>> getAllFilms();

    @Operation(summary = "Atualiza a descrição de um filme especifico", description = "Dado um id do filme e uma descrição no body o filme é atualizado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Filme nao encontrado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
    ResponseEntity<Void> patchFilm(UpdateFilmRequestDto updateFilmRequestDto);

    @Operation(summary = "Devolve um filme especifico com poucos detalhes", description = "Devolve um filme com base em um id com poucos detalhes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso", content = @Content(schema = @Schema(implementation = FilmResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Filme não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
    ResponseEntity<FilmResponseDto> getFilmDetails(Integer episodeId);

    @Operation(summary = "Devolve um filme especifico com todos os detalhes", description = "Devolve um filme com base em um id com todos os detalhes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso", content = @Content(schema = @Schema(implementation = FilmDetailResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Filme não encontrado", content = @Content(schema = @Schema(implementation = ResponseError.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(schema = @Schema(implementation = ResponseError.class)))
    })
    ResponseEntity<FilmDetailResponseDto> getFilmDetail(Integer episodeId);
}
