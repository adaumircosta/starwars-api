package br.com.starwars.api.service.impl;

import br.com.starwars.api.adapter.domain.FilmMapperAdapter;
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
        return FilmMapperAdapter.INSTANCE.convertList(repositoryService.getAllFilms());
    }

    @Override
    public Film getFilmDetails(Integer episodeId) {
        return FilmMapperAdapter.INSTANCE.convert(repositoryService.getFilmDetails(episodeId));
    }

    @Override
    public Film getFilmDetail(Integer episodeId) {
        return FilmMapperAdapter.INSTANCE.convert(repositoryService.getFilmDetails(episodeId));
    }
}
