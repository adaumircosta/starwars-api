package br.com.starwars.api.resource;

import br.com.starwars.api.resource.dto.FilmDetailResponseDto;
import br.com.starwars.api.resource.dto.FilmResponseDto;
import br.com.starwars.api.resource.dto.UpdateFilmRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SWApiController {

    ResponseEntity<List<FilmResponseDto>> getAllFilms();
    ResponseEntity<Void> patchFilm(UpdateFilmRequestDto updateFilmRequestDto);
    ResponseEntity<FilmResponseDto> getFilmDetails(Integer episodeId);
    ResponseEntity<FilmDetailResponseDto> getFilmDetail(Integer episodeId);
}
