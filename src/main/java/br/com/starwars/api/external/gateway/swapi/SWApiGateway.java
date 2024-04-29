package br.com.starwars.api.external.gateway.swapi;

import br.com.starwars.api.external.gateway.swapi.dto.FilmDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.PersonDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.PlanetDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.SpeciesDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.StarshipDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.VehicleDetailClientResponseDto;

import java.util.List;

public interface SWApiGateway {

    List<FilmDetailClientResponseDto> getFilms();
    List<PersonDetailClientResponseDto> getPeople();
    List<PlanetDetailClientResponseDto> getPlanets();
    List<StarshipDetailClientResponseDto> getStarships();
    List<VehicleDetailClientResponseDto> getVehicles();
    List<SpeciesDetailClientResponseDto> getSpecies();
}
