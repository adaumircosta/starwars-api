package br.com.starwars.api.external.gateway.swapi.impl;

import br.com.starwars.api.external.gateway.swapi.SWApiGateway;
import br.com.starwars.api.external.gateway.swapi.client.SWApiClient;
import br.com.starwars.api.external.gateway.swapi.dto.FilmClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.PersonClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.PlanetClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.SpeciesClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.StarshipClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.VehicleClientResponseDto;
import br.com.starwars.api.utils.ObjectMapperUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SWApiGatewayImplTest {

    private SWApiGateway swApiGateway;
    private SWApiClient swApiClient;

    @BeforeEach
    void setUp() {
        swApiClient = mock(SWApiClient.class);
        swApiGateway = new SWApiGatewayImpl(swApiClient);
    }

    @Test
    void shouldGetSucessFullyAllFilmFromApi() throws IOException {

        FilmClientResponseDto expected = ObjectMapperUtils.readValue("src/test/resources/files/json_films.json", FilmClientResponseDto.class);

        when(swApiClient.getFilms()).thenReturn(ResponseEntity.ok(expected));
        var result = swApiGateway.getFilms();

        assertEquals(expected.getResults(), result);
    }

    @Test
    void shouldGetSucessFullyAlPeopleFromApi() throws IOException {

        PersonClientResponseDto expected = ObjectMapperUtils.readValue("src/test/resources/files/json_people.json", PersonClientResponseDto.class);

        when(swApiClient.getPeople(anyInt())).thenReturn(ResponseEntity.ok(expected));
        var result = swApiGateway.getPeople();

        assertEquals(expected.getResults(), result);
    }

    @Test
    void shouldGetSucessFullyAlPlanetsFromApi() throws IOException {

        PlanetClientResponseDto expected = ObjectMapperUtils.readValue("src/test/resources/files/json_planets.json", PlanetClientResponseDto.class);

        when(swApiClient.getPlanets(anyInt())).thenReturn(ResponseEntity.ok(expected));
        var result = swApiGateway.getPlanets();

        assertEquals(expected.getResults(), result);
    }

    @Test
    void shouldGetSucessFullyAlStarshipsFromApi() throws IOException {

        StarshipClientResponseDto expected = ObjectMapperUtils.readValue("src/test/resources/files/json_starships.json", StarshipClientResponseDto.class);

        when(swApiClient.getStarships(anyInt())).thenReturn(ResponseEntity.ok(expected));
        var result = swApiGateway.getStarships();

        assertEquals(expected.getResults(), result);
    }

    @Test
    void shouldGetSucessFullyAlVehiclesFromApi() throws IOException {

        VehicleClientResponseDto expected = ObjectMapperUtils.readValue("src/test/resources/files/json_vehicles.json", VehicleClientResponseDto.class);

        when(swApiClient.getVehicles(anyInt())).thenReturn(ResponseEntity.ok(expected));
        var result = swApiGateway.getVehicles();

        assertEquals(expected.getResults(), result);
    }

    @Test
    void shouldGetSucessFullyAlSpeciesFromApi() throws IOException {

        SpeciesClientResponseDto expected = ObjectMapperUtils.readValue("src/test/resources/files/json_species.json", SpeciesClientResponseDto.class);

        when(swApiClient.getSpecies(anyInt())).thenReturn(ResponseEntity.ok(expected));
        var result = swApiGateway.getSpecies();

        assertEquals(expected.getResults(), result);
    }


}
