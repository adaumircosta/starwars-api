package br.com.starwars.api.external.repository.starwars.services.impl;

import br.com.starwars.api.exceptions.DatabaseException;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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

    @Override
    public void updateFilm(Integer episodeId, String description) {
        try {

            var qtd = filmRepository.updateDescription(episodeId, description);
            log.info("Foram atualizado {} registros", qtd);
        } catch (DataAccessException ex) {
            log.error("Erro na atualização da descrição do Film: {}", ex.toString());
            throw new DatabaseException("Database Error", "Houve um erro na iteração com o banco de dados");
        }
    }

    @Override
    public boolean existsId(Integer episodeId) {
        return filmRepository.existsById(episodeId);
    }


}
