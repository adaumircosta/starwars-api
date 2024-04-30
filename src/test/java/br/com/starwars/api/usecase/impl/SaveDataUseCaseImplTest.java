package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.domain.Person;
import br.com.starwars.api.domain.Planet;
import br.com.starwars.api.domain.ProcessDataSW;
import br.com.starwars.api.domain.Species;
import br.com.starwars.api.domain.Starship;
import br.com.starwars.api.domain.Vehicle;
import br.com.starwars.api.external.repository.starwars.services.RepositoryService;
import br.com.starwars.api.usecase.ProcessDataDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class SaveDataUseCaseImplTest {

    private RepositoryService repository;
    private ProcessDataDecorator useCase;


    @BeforeEach
    void setUp() {
        repository = mock(RepositoryService.class);
        useCase = new SaveDataUseCaseImpl(repository);
    }

    @Test
    void mustConvertAndInsertOnDatabase() {

        var data = ProcessDataSW
                .builder()
                .film(List.of(Film.builder().url("https://swapi.dev/api/films/5/").build()))
                .person(List.of(Person.builder().url("https://swapi.dev/api/people/9/").build()))
                .species(List.of(Species.builder().url("https://swapi.dev/api/species/3/").build()))
                .starship(List.of(Starship.builder().url("https://swapi.dev/api/starships/10/").build()))
                .vehicle(List.of(Vehicle.builder().url("https://swapi.dev/api/vehicles/7/").build()))
                .planet(List.of(Planet.builder().url("https://swapi.dev/api/planets/2/").build()))
                .build();

        doNothing().when(repository).insertAllFilms(anyList());
        doNothing().when(repository).insertAllPeople(anyList());
        doNothing().when(repository).insertAllSpecies(anyList());
        doNothing().when(repository).insertAllStarships(anyList());
        doNothing().when(repository).insertAllVehicles(anyList());
        doNothing().when(repository).insertAllPlanets(anyList());


        assertDoesNotThrow(() -> useCase.execute(data));
    }
}
