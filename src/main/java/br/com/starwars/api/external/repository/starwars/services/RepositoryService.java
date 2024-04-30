package br.com.starwars.api.external.repository.starwars.services;

import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonEntity;
import br.com.starwars.api.external.repository.starwars.entities.PlanetEntity;
import br.com.starwars.api.external.repository.starwars.entities.SpeciesEntity;
import br.com.starwars.api.external.repository.starwars.entities.StarshipEntity;
import br.com.starwars.api.external.repository.starwars.entities.VehicleEntity;

import java.util.List;

public interface RepositoryService {

    void insertAllFilms(List<FilmEntity> list);
    void insertAllPeople(List<PersonEntity> list);
    void insertAllPlanets(List<PlanetEntity> list);
    void insertAllSpecies(List<SpeciesEntity> list);
    void insertAllStarships(List<StarshipEntity> list);
    void insertAllVehicles(List<VehicleEntity> list);
    List<FilmEntity> getAllFilms();
    FilmEntity getFilmDetails(int episodeId);
    void updateFilm(Integer episodeId, String description);
}
