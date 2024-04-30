package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.domain.ProcessDataSW;
import br.com.starwars.api.usecase.ProcessDataDecorator;
import br.com.starwars.api.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Order(2)
@Service
@RequiredArgsConstructor
public class AssociationDataUseCaseImpl implements ProcessDataDecorator {


    @Override
    public void execute(ProcessDataSW processDataSW) {
        associationFilmPersonData(processDataSW);
    }

    private void associationFilmPersonData(ProcessDataSW processDataSW) {
        setAssociationIds(processDataSW.getFilm());
    }

    private void setAssociationIds(List<Film> films) {
        films.stream().parallel().forEach(film -> {

            film.getPlanets().parallelStream().forEach(planet -> {

                var personId = Integer.parseInt(StringUtils.extractValueFromURL(planet.getUrl()));
                planet.setId(personId);
            });

            film.getCharacters().parallelStream().forEach(person -> {
                var characterId = Integer.parseInt(StringUtils.extractValueFromURL(person.getUrl()));
                person.setId(characterId);
            });

            film.getSpecies().parallelStream().forEach(species -> {
                var speciesId = Integer.parseInt(StringUtils.extractValueFromURL(species.getUrl()));
                species.setId(speciesId);
            });

            film.getVehicles().parallelStream().forEach(vehicle -> {
                var vehicleId = Integer.parseInt(StringUtils.extractValueFromURL(vehicle.getUrl()));
                vehicle.setId(vehicleId);
            });

            film.getStarships().parallelStream().forEach(starship -> {
                var starshipId = Integer.parseInt(StringUtils.extractValueFromURL(starship.getUrl()));
                starship.setId(starshipId);
            });
        });
    }
}
