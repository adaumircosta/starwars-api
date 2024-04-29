package br.com.starwars.api.resource;

import br.com.starwars.api.adapter.resource.FilmResponseDtoMapperAdapter;
import br.com.starwars.api.resource.dto.FilmResponseDto;
import br.com.starwars.api.service.GetFilmDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Override
    @GetMapping
    public ResponseEntity<List<FilmResponseDto>> getAllFilms() {
        var response = service.getAllFilm();
        var result = FilmResponseDtoMapperAdapter.INSTANCE.convert(response);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Void> patchFilm(String descrption) {
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping(value = "/details")
    public ResponseEntity<FilmResponseDto> getFilmDetails(@RequestParam Integer episodeId) {

        var response = FilmResponseDtoMapperAdapter.INSTANCE.convert(service.getFilmDetails(episodeId));
        if(nonNull(response)){
            return ResponseEntity.ok(response);
        }
        return  ResponseEntity.notFound().build();
    }

    @Override
    @GetMapping(value = "/detail")
    public ResponseEntity<FilmResponseDto> getFilmDetail(@RequestParam Integer episodeId) {

        var response = FilmResponseDtoMapperAdapter.INSTANCE.convert(service.getFilmDetail(episodeId));
        if(nonNull(response)){
            return ResponseEntity.ok(response);
        }
        return  ResponseEntity.notFound().build();
    }
}
