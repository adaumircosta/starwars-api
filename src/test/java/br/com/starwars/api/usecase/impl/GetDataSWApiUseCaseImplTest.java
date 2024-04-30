package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.domain.ProcessDataSW;
import br.com.starwars.api.external.gateway.swapi.SWApiGateway;
import br.com.starwars.api.external.gateway.swapi.dto.FilmDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.PersonDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.PlanetDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.SpeciesDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.StarshipDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.VehicleDetailClientResponseDto;
import br.com.starwars.api.usecase.ProcessDataDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetDataSWApiUseCaseImplTest {

    private SWApiGateway swApiGateway;
    private ProcessDataDecorator useCase;

    @BeforeEach
    void setUp() {
        swApiGateway = mock(SWApiGateway.class);
        useCase = new GetDataSWApiUseCaseImpl(swApiGateway);
    }

    @Test
    void mustBeExecuteCallAndDoesntThrowException() {

        when(swApiGateway.getFilms()).thenReturn(List.of(new FilmDetailClientResponseDto()));
        when(swApiGateway.getPeople()).thenReturn(List.of(new PersonDetailClientResponseDto()));
        when(swApiGateway.getPlanets()).thenReturn(List.of(new PlanetDetailClientResponseDto()));
        when(swApiGateway.getSpecies()).thenReturn(List.of(new SpeciesDetailClientResponseDto()));
        when(swApiGateway.getStarships()).thenReturn(List.of(new StarshipDetailClientResponseDto()));
        when(swApiGateway.getVehicles()).thenReturn(List.of(new VehicleDetailClientResponseDto()));

        assertDoesNotThrow(() -> useCase.execute(new ProcessDataSW()));

        verify(swApiGateway, times(1)).getFilms();
        verify(swApiGateway, times(1)).getPeople();
        verify(swApiGateway, times(1)).getPlanets();
        verify(swApiGateway, times(1)).getSpecies();
        verify(swApiGateway, times(1)).getStarships();
        verify(swApiGateway, times(1)).getVehicles();
    }
}
