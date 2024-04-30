package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.adapter.domain.FilmMapperAdapter;
import br.com.starwars.api.adapter.domain.PersonMapperAdapter;
import br.com.starwars.api.adapter.domain.PlanetMapperAdapter;
import br.com.starwars.api.adapter.domain.SpeciesMapperAdapter;
import br.com.starwars.api.adapter.domain.StarshipMapperAdapter;
import br.com.starwars.api.adapter.domain.VehicleMapperAdapter;
import br.com.starwars.api.domain.Film;
import br.com.starwars.api.domain.Person;
import br.com.starwars.api.domain.Planet;
import br.com.starwars.api.domain.ProcessDataSW;
import br.com.starwars.api.domain.Species;
import br.com.starwars.api.domain.Starship;
import br.com.starwars.api.domain.Vehicle;
import br.com.starwars.api.external.gateway.swapi.SWApiGateway;
import br.com.starwars.api.usecase.ProcessDataDecorator;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Order(1)
@Service
@RequiredArgsConstructor
public class GetDataSWApiUseCaseImpl implements ProcessDataDecorator {

    private final SWApiGateway swApiGateway;

    @Override
    public void execute(ProcessDataSW processDataSW) {
        setData(processDataSW);
    }

    public void setData(ProcessDataSW processDataSW) {
        processDataSW.setFilm(getFilms());
        processDataSW.setPerson(getPeople());
        processDataSW.setPlanet(getPlanets());
        processDataSW.setSpecies(getSpecies());
        processDataSW.setVehicle(getVehicles());
        processDataSW.setStarship(getStarships());
    }

    private List<Film> getFilms() {
        var result = swApiGateway.getFilms();
        return FilmMapperAdapter.INSTANCE.convert(result);
    }

    private List<Person> getPeople() {
        var result = swApiGateway.getPeople();
        return PersonMapperAdapter.INSTANCE.convert(result);
    }

    private List<Planet> getPlanets() {
        var result = swApiGateway.getPlanets();
        return  PlanetMapperAdapter.INSTANCE.convert(result);
    }

    private List<Species> getSpecies() {
        var result = swApiGateway.getSpecies();
        return  SpeciesMapperAdapter.INSTANCE.convert(result);
    }

    private List<Starship> getStarships() {
        var result = swApiGateway.getStarships();
        return  StarshipMapperAdapter.INSTANCE.convert(result);
    }

    private List<Vehicle> getVehicles() {
        var result = swApiGateway.getVehicles();
        return  VehicleMapperAdapter.INSTANCE.convert(result);
    }
}
