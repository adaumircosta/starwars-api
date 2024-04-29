package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.adapter.entities.FilmPersonEntityAdapter;
import br.com.starwars.api.adapter.entities.FilmPlanetEntityAdapter;
import br.com.starwars.api.adapter.entities.FilmSpeciesEntityAdapter;
import br.com.starwars.api.adapter.entities.FilmStarshipEntityAdapter;
import br.com.starwars.api.adapter.entities.FilmVehicleEntityAdapter;
import br.com.starwars.api.adapter.entities.PersonSpeciesEntityAdapter;
import br.com.starwars.api.adapter.entities.PersonStarshipEntityAdapter;
import br.com.starwars.api.adapter.entities.PersonVehicleEntityAdapter;
import br.com.starwars.api.adapter.entities.PlanetPersonEntityAdapter;
import br.com.starwars.api.domain.ProcessDataSW;
import br.com.starwars.api.external.repository.starwars.services.RepositoryService;
import br.com.starwars.api.usecase.ProcessDataDecorator;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Order(3)
@Service
@RequiredArgsConstructor
public class SaveAssociationDataImpl implements ProcessDataDecorator {

    private final RepositoryService repository;

    @Override
    public void execute(ProcessDataSW processDataSW) {
        saveFilmPersonData(processDataSW);
        saveFilmPlanetData(processDataSW);
        saveFilmSpeciesData(processDataSW);
        saveFilmVehicleData(processDataSW);
        saveFilmStarshipData(processDataSW);
        savePersonVehicleData(processDataSW);
        savePersonStarshipData(processDataSW);
        savePersonSpeciesData(processDataSW);
        savePlanetPersonData(processDataSW);
    }

    private void saveFilmPersonData(ProcessDataSW processDataSW) {
        var list = FilmPersonEntityAdapter.convert(processDataSW.getFilm());
        repository.insertAllFilmPerson(list);
    }

    private void saveFilmPlanetData(ProcessDataSW processDataSW) {
        var list = FilmPlanetEntityAdapter.convert(processDataSW.getFilm());
        repository.insertAllFilmPlanet(list);
    }

    private void saveFilmSpeciesData(ProcessDataSW processDataSW) {
        var list = FilmSpeciesEntityAdapter.convert(processDataSW.getFilm());
        repository.insertAllFilmSpecies(list);
    }

    private void saveFilmVehicleData(ProcessDataSW processDataSW) {
        var list = FilmVehicleEntityAdapter.convert(processDataSW.getFilm());
        repository.insertAllFilmVehicle(list);
    }

    private void saveFilmStarshipData(ProcessDataSW processDataSW) {
        var list = FilmStarshipEntityAdapter.convert(processDataSW.getFilm());
        repository.insertAllFilmStarship(list);
    }

    private void savePersonVehicleData(ProcessDataSW processDataSW) {
        var list = PersonVehicleEntityAdapter.convert(processDataSW.getPerson());
        repository.insertAllPersonVehicle(list);
    }

    private void savePersonStarshipData(ProcessDataSW processDataSW) {
        var list = PersonStarshipEntityAdapter.convert(processDataSW.getPerson());
        repository.insertAllPersonStarship(list);
    }

    private void savePersonSpeciesData(ProcessDataSW processDataSW) {
        var list = PersonSpeciesEntityAdapter.convert(processDataSW.getPerson());
        repository.insertAllPersonSpecies(list);
    }

    private void savePlanetPersonData(ProcessDataSW processDataSW) {
        var list = PlanetPersonEntityAdapter.convert(processDataSW.getPlanet());
        repository.insertAllPlanetPerson(list);
    }
}
