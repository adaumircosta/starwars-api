package br.com.starwars.api.external.gateway.swapi.impl;

import br.com.starwars.api.external.gateway.swapi.SWApiGateway;
import br.com.starwars.api.external.gateway.swapi.client.SWApiClient;
import br.com.starwars.api.external.gateway.swapi.dto.FilmDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.PersonDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.PlanetDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.SWApiClientReponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.SpeciesDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.StarshipDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.VehicleDetailClientResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class SWApiGatewayImpl implements SWApiGateway {

    private final SWApiClient swApiClient;

    @Override
    public List<FilmDetailClientResponseDto> getFilms() {
        var response = swApiClient.getFilms();
        if (nonNull(response) && nonNull(response.getBody())) {
            return response.getBody().getResults();
        }
        return null;
    }

    @Override
    public List<PersonDetailClientResponseDto> getPeople() {
        return fetchDataFromApi(swApiClient::getPeople);
    }

    @Override
    public List<PlanetDetailClientResponseDto> getPlanets() {
        return fetchDataFromApi(swApiClient::getPlanets);
    }

    @Override
    public List<StarshipDetailClientResponseDto> getStarships() {
        return fetchDataFromApi(swApiClient::getStarships);
    }

    @Override
    public List<VehicleDetailClientResponseDto> getVehicles() {
        return fetchDataFromApi(swApiClient::getVehicles);
    }

    @Override
    public List<SpeciesDetailClientResponseDto> getSpecies() {
        return fetchDataFromApi(swApiClient::getSpecies);
    }

    @SuppressWarnings("unchecked")
    private <T extends SWApiClientReponseDto, R> List<R> fetchDataFromApi(IntFunction<ResponseEntity<T>> apiMethod) {
        int page = 1;
        List<R> results = new ArrayList<>();
        ResponseEntity<T> response;
        do {
            response = apiMethod.apply(page);
            if (nonNull(response) && nonNull(response.getBody())) {
                results.addAll((List<R>) response.getBody().getResults());
                page++;
            }
        } while (nonNull(response) && nonNull(response.getBody()) && nonNull(response.getBody().getNext()));
        return results;
    }
}
