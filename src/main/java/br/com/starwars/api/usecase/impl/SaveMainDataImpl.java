package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.adapter.entities.FilmEntityMapperAdapter;
import br.com.starwars.api.adapter.entities.PersonEntityMapperAdapter;
import br.com.starwars.api.adapter.entities.PlanetEntityMapperAdapter;
import br.com.starwars.api.adapter.entities.SpeciesEntityMapperAdapter;
import br.com.starwars.api.adapter.entities.StarshipEntityMapperAdapter;
import br.com.starwars.api.adapter.entities.VehicleEntityMapperAdapter;
import br.com.starwars.api.domain.ProcessDataSW;
import br.com.starwars.api.external.repository.starwars.services.RepositoryService;
import br.com.starwars.api.usecase.ProcessDataDecorator;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(2)
@Service
@RequiredArgsConstructor
public class SaveMainDataImpl implements ProcessDataDecorator {

    private final RepositoryService repository;

    @Override
    public void execute(ProcessDataSW processDataSW) {
        saveMainFilmData(processDataSW);
        saveMainPlanetData(processDataSW);
        saveMainStarshipData(processDataSW);
        saveMainVehicleData(processDataSW);
        saveMainSpeciesData(processDataSW);
        saveMainPersonData(processDataSW);
    }

    private void saveMainFilmData(ProcessDataSW processDataSW) {
        var list = FilmEntityMapperAdapter.INSTANCE.convert(processDataSW.getFilm());
        repository.insertAllFilms(list);
    }

    private void saveMainPersonData(ProcessDataSW processDataSW) {
        var list = PersonEntityMapperAdapter.INSTANCE.convert(processDataSW.getPerson());
        repository.insertAllPeople(list);
    }

    private void saveMainPlanetData(ProcessDataSW processDataSW) {
        var list = PlanetEntityMapperAdapter.INSTANCE.convert(processDataSW.getPlanet());
        repository.insertAllPlanets(list);
    }

    private void saveMainSpeciesData(ProcessDataSW processDataSW) {
        var list = SpeciesEntityMapperAdapter.INSTANCE.convert(processDataSW.getSpecies());
        repository.insertAllSpecies(list);
    }

    private void saveMainStarshipData(ProcessDataSW processDataSW) {
        var list = StarshipEntityMapperAdapter.INSTANCE.convert(processDataSW.getStarship());
        repository.insertAllStarships(list);
    }

    private void saveMainVehicleData(ProcessDataSW processDataSW) {
        var list = VehicleEntityMapperAdapter.INSTANCE.convert(processDataSW.getVehicle());
        repository.insertAllVehicles(list);
    }
}
