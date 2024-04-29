package br.com.starwars.api.external.repository.starwars.services;

import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmPersonEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmPlanetEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmSpeciesEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmStarshipEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmVehicleEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonSpeciesEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonStarshipEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonVehicleEntity;
import br.com.starwars.api.external.repository.starwars.entities.PlanetEntity;
import br.com.starwars.api.external.repository.starwars.entities.PlanetPersonEntity;
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
    void insertAllFilmPerson(List<FilmPersonEntity> list);
    void insertAllFilmPlanet(List<FilmPlanetEntity> list);
    void insertAllFilmSpecies(List<FilmSpeciesEntity> list);
    void insertAllFilmVehicle(List<FilmVehicleEntity> list);
    void insertAllFilmStarship(List<FilmStarshipEntity> list);
    void insertAllPersonVehicle(List<PersonVehicleEntity> list);
    void insertAllPersonStarship(List<PersonStarshipEntity> list);
    void insertAllPersonSpecies(List<PersonSpeciesEntity> list);
    void insertAllPlanetPerson(List<PlanetPersonEntity> list);

    List<FilmEntity> getAllFilms();
    FilmEntity getFilmDetails(int episodeId);
}
