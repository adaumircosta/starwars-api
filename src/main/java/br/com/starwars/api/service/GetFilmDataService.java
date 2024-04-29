package br.com.starwars.api.service;

import br.com.starwars.api.domain.Film;

import java.util.List;

public interface GetFilmDataService {

    List<Film> getAllFilm();
    Film getFilmDetails(Integer episodeId);
    Film getFilmDetail(Integer episodeId);
}
