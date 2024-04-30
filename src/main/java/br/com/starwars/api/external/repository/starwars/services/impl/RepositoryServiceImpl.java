package br.com.starwars.api.external.repository.starwars.services.impl;

import br.com.starwars.api.external.repository.starwars.FilmRepository;
import br.com.starwars.api.external.repository.starwars.PersonRepository;
import br.com.starwars.api.external.repository.starwars.PlanetRepository;
import br.com.starwars.api.external.repository.starwars.SpeciesRepository;
import br.com.starwars.api.external.repository.starwars.StarshipRepository;
import br.com.starwars.api.external.repository.starwars.VehicleRepository;
import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonEntity;
import br.com.starwars.api.external.repository.starwars.entities.PlanetEntity;
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


    @Override
    public void insertAllFilms(List<FilmEntity> list) {
        filmRepository.saveAllAndFlush(list);
    }

    @Override
    public void insertAllPeople(List<PersonEntity> list) {
        personRepository.saveAllAndFlush(list);
    }

    @Override
    public void insertAllPlanets(List<PlanetEntity> list) {
        planetRepository.saveAllAndFlush(list);
    }

    @Override
    public void insertAllSpecies(List<SpeciesEntity> list) {
        speciesRepository.saveAllAndFlush(list);
    }

    @Override
    public void insertAllStarships(List<StarshipEntity> list) {
        starshipRepository.saveAllAndFlush(list);

    }

    @Override
    public void insertAllVehicles(List<VehicleEntity> list) {
        vehicleRepository.saveAllAndFlush(list);
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
