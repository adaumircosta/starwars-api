package br.com.starwars.api.service.impl;

import br.com.starwars.api.adapter.domain.FilmAdapter;
import br.com.starwars.api.domain.Film;
import br.com.starwars.api.external.repository.starwars.services.RepositoryService;
import br.com.starwars.api.service.GetFilmDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetFilmDataServiceImpl implements GetFilmDataService {

    private final RepositoryService repositoryService;


    @Override
    public List<Film> getAllFilm() {
        return FilmAdapter.convertToFilm(repositoryService.getAllFilms());
    }

    @Override
    public Film getFilmDetails(Integer episodeId) {
        return FilmAdapter.filmEntityToFilm(repositoryService.getFilmDetails(episodeId));
    }

    @Override
    public Film getFilmDetail(Integer episodeId) {
        return FilmAdapter.filmEntityToFilmDetail(repositoryService.getFilmDetails(episodeId));
    }
}
