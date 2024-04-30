package br.com.starwars.api.service;

import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import br.com.starwars.api.external.repository.starwars.services.RepositoryService;
import br.com.starwars.api.service.impl.GetFilmDataServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetFilmDataServiceImplTest {

    private RepositoryService repository;
    private GetFilmDataService service;

    @BeforeEach
    void setUp() {
        repository = mock(RepositoryService.class);
        service = new GetFilmDataServiceImpl(repository);
    }

    @Test
    void mustBeTypeFilm() {

        var expected = List.of(new FilmEntity());

        when(repository.getAllFilms()).thenReturn(expected);
        var result = service.getAllFilm();

        assertEquals(expected.size(), result.size());
    }

    @Test
    void mustBeTypeFilmDetails() {

        var expected = new FilmEntity();

        when(repository.getFilmDetails(anyInt())).thenReturn(expected);
        var result = service.getFilmDetails(1);

        assertEquals(expected.getId(), result.getId());
    }

    @Test
    void mustBeTypeFilmDetail() {

        var expected = new FilmEntity();

        when(repository.getFilmDetails(anyInt())).thenReturn(expected);
        var result = service.getFilmDetail(1);

        assertEquals(expected.getId(), result.getId());
    }


}
