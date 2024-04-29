package br.com.starwars.api.external.gateway.swapi.client;

import br.com.starwars.api.config.FeignConfig;
import br.com.starwars.api.external.gateway.swapi.dto.FilmClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.PersonClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.PlanetClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.SpeciesClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.StarshipClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.VehicleClientResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${services.swapi.name}", url = "${services.swapi.url}", configuration = FeignConfig.class)
public interface SWApiClient {

    @GetMapping(path = "${services.swapi.endpoint-films}")
    ResponseEntity<FilmClientResponseDto> getFilms();

    @GetMapping(path = "${services.swapi.endpoint-people}")
    ResponseEntity<PersonClientResponseDto> getPeople(@RequestParam int page);

    @GetMapping(path = "${services.swapi.endpoint-planets}")
    ResponseEntity<PlanetClientResponseDto> getPlanets(@RequestParam int page);

    @GetMapping(path = "${services.swapi.endpoint-starships}")
    ResponseEntity<StarshipClientResponseDto> getStarships(@RequestParam int page);

    @GetMapping(path = "${services.swapi.endpoint-vehicles}")
    ResponseEntity<VehicleClientResponseDto> getVehicles(@RequestParam int page);

    @GetMapping(path = "${services.swapi.endpoint-species}")
    ResponseEntity<SpeciesClientResponseDto> getSpecies(@RequestParam int page);
}
