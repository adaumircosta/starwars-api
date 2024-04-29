package br.com.starwars.api.external.repository.starwars.services.impl;

import br.com.starwars.api.external.repository.starwars.FilmPersonRepository;
import br.com.starwars.api.external.repository.starwars.FilmPlanetRepository;
import br.com.starwars.api.external.repository.starwars.FilmRepository;
import br.com.starwars.api.external.repository.starwars.FilmSpeciesRepository;
import br.com.starwars.api.external.repository.starwars.FilmStarshipRepository;
import br.com.starwars.api.external.repository.starwars.FilmVehicleRepository;
import br.com.starwars.api.external.repository.starwars.PersonRepository;
import br.com.starwars.api.external.repository.starwars.PersonSpeciesRepository;
import br.com.starwars.api.external.repository.starwars.PersonStarshipRepository;
import br.com.starwars.api.external.repository.starwars.PersonVehicleRepository;
import br.com.starwars.api.external.repository.starwars.PlanetPersonRepository;
import br.com.starwars.api.external.repository.starwars.PlanetRepository;
import br.com.starwars.api.external.repository.starwars.SpeciesRepository;
import br.com.starwars.api.external.repository.starwars.StarshipRepository;
import br.com.starwars.api.external.repository.starwars.VehicleRepository;
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
import br.com.starwars.api.external.repository.starwars.services.RepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepositoryServiceImpl implements RepositoryService {

    private final FilmRepository filmRepository;
    private final PersonRepository personRepository;
    private final PlanetRepository planetRepository;
    private final SpeciesRepository speciesRepository;
    private final StarshipRepository starshipRepository;
    private final VehicleRepository vehicleRepository;
    private final FilmPersonRepository filmPersonRepository;
    private final FilmPlanetRepository filmPlanetRepository;
    private final FilmSpeciesRepository filmSpeciesRepository;
    private final FilmVehicleRepository filmVehicleRepository;
    private final FilmStarshipRepository filmStarshipRepository;
    private final PersonVehicleRepository personVehicleRepository;
    private final PersonStarshipRepository personStarshipRepository;
    private final PersonSpeciesRepository personSpeciesRepository;
    private final PlanetPersonRepository planetPersonRepository;

    @Override
    public void insertAllFilms(List<FilmEntity> list) {
        filmRepository.saveAll(list);
    }

    @Override
    public void insertAllPeople(List<PersonEntity> list) {
        personRepository.saveAll(list);
    }

    @Override
    public void insertAllPlanets(List<PlanetEntity> list) {
        planetRepository.saveAll(list);
    }

    @Override
    public void insertAllSpecies(List<SpeciesEntity> list) {
        speciesRepository.saveAll(list);
    }

    @Override
    public void insertAllStarships(List<StarshipEntity> list) {
        starshipRepository.saveAll(list);
    }

    @Override
    public void insertAllVehicles(List<VehicleEntity> list) {
        vehicleRepository.saveAll(list);
    }

    @Override
    public void insertAllFilmPerson(List<FilmPersonEntity> list) {
        filmPersonRepository.saveAll(list);
    }

    @Override
    public void insertAllFilmPlanet(List<FilmPlanetEntity> list) {
        filmPlanetRepository.saveAll(list);
    }

    @Override
    public void insertAllFilmSpecies(List<FilmSpeciesEntity> list) {
        filmSpeciesRepository.saveAll(list);
    }

    @Override
    public void insertAllFilmVehicle(List<FilmVehicleEntity> list) {
        filmVehicleRepository.saveAll(list);
    }

    @Override
    public void insertAllFilmStarship(List<FilmStarshipEntity> list) {
        filmStarshipRepository.saveAll(list);
    }

    @Override
    public void insertAllPersonVehicle(List<PersonVehicleEntity> list) {
        personVehicleRepository.saveAll(list);
    }

    @Override
    public void insertAllPersonStarship(List<PersonStarshipEntity> list) {
        personStarshipRepository.saveAll(list);
    }

    @Override
    public void insertAllPersonSpecies(List<PersonSpeciesEntity> list) {
        personSpeciesRepository.saveAll(list);
    }

    @Override
    public void insertAllPlanetPerson(List<PlanetPersonEntity> list) {
        planetPersonRepository.saveAll(list);
    }

    @Override
    public List<FilmEntity> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public FilmEntity getFilmDetails(int episodeId) {
        return filmRepository.findByEpisodeId(episodeId);

    }


}
