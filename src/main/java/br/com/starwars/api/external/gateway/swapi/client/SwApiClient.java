package br.com.starwars.api.external.gateway.swapi.client;

import br.com.starwars.api.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${services.swapi.name}", url = "${service.swapi.url}", configuration = FeignConfig.class)
public interface SwApiClient {

    @GetMapping(path = "${service.swapi.endpoint-films}")
    ResponseEntity getFilms();

    @GetMapping(path = "${service.swapi.endpoint-people}")
    ResponseEntity getPeople(@RequestParam(required = false)  int page);

    @GetMapping(path = "${service.swapi.endpoint-planets}")
    ResponseEntity getPlanets(@RequestParam(required = false)  int page);

    @GetMapping(path = "${service.swapi.endpoint-starships}")
    ResponseEntity getStarships(@RequestParam(required = false)  int page);

    @GetMapping(path = "${service.swapi.endpoint-vehicles}")
    ResponseEntity getVehicles(@RequestParam(required = false)  int page);

    @GetMapping(path = "${service.swapi.endpoint-species}")
    ResponseEntity getSpecies(@RequestParam(required = false)  int page);
}
