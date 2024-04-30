package br.com.starwars.api.resource;

import br.com.starwars.api.adapter.resource.FilmDetailResponseDtoMapperAdapter;
import br.com.starwars.api.adapter.resource.FilmResponseDtoMapperAdapter;
import br.com.starwars.api.resource.dto.FilmDetailResponseDto;
import br.com.starwars.api.resource.dto.FilmResponseDto;
import br.com.starwars.api.resource.dto.UpdateFilmRequestDto;
import br.com.starwars.api.service.GetFilmDataService;
import br.com.starwars.api.usecase.UpdateFilmUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/starwars")
public class SWApiControllerImpl implements SWApiController {

    private final GetFilmDataService service;
    private final UpdateFilmUseCase updateFilmUseCase;

    @Override
    @GetMapping
    public ResponseEntity<List<FilmResponseDto>> getAllFilms() {
        var response = service.getAllFilm();
        var result = FilmResponseDtoMapperAdapter.INSTANCE.convert(response);
        return ResponseEntity.ok(result);
    }

    @Override
    @PatchMapping(value = "/film")
    public ResponseEntity<Void> patchFilm(@RequestBody final UpdateFilmRequestDto updateFilmRequestDto) {
        updateFilmUseCase.execute(updateFilmRequestDto.getEpisodeId(), updateFilmRequestDto.getDescription());
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping(value = "/detalhes")
    public ResponseEntity<FilmResponseDto> getFilmDetails(@RequestParam final Integer episodeId) {

        var response = FilmResponseDtoMapperAdapter.INSTANCE.convert(service.getFilmDetails(episodeId));
        if(nonNull(response)){
            return ResponseEntity.ok(response);
        }
        return  ResponseEntity.notFound().build();
    }

    @Override
    @GetMapping(value = "/detalhar")
    public ResponseEntity<FilmDetailResponseDto> getFilmDetail(@RequestParam final Integer episodeId) {

        var response = FilmDetailResponseDtoMapperAdapter.INSTANCE.convert(service.getFilmDetail(episodeId));
        if(nonNull(response)){
            return ResponseEntity.ok(response);
        }
        return  ResponseEntity.notFound().build();
    }
}
