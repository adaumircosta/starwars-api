package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Planet;
import br.com.starwars.api.external.repository.starwars.entities.PersonEntity;
import br.com.starwars.api.external.repository.starwars.entities.PlanetEntity;
import br.com.starwars.api.external.repository.starwars.entities.PlanetPersonEntity;
import br.com.starwars.api.external.repository.starwars.entities.PlanetPersonIdEntity;
import br.com.starwars.api.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class PlanetPersonEntityAdapter {


    public List<PlanetPersonEntity> convert(List<Planet> planets){
        List<PlanetPersonEntity> list = new ArrayList<>();
        planets.stream().parallel().forEach(planet -> planet.getResidents().stream().parallel().forEach(person -> {

            var planetId = Integer.parseInt(StringUtils.extractValueFromURL(planet.getUrl()));
            var personId = Integer.parseInt(StringUtils.extractValueFromURL(person.getUrl()));

            PlanetPersonIdEntity planetPersonIdEntity = new PlanetPersonIdEntity();
            planetPersonIdEntity.setPlanetId(planetId);
            planetPersonIdEntity.setPersonId(personId);

            PlanetEntity planetEntity = new PlanetEntity();
            planetEntity.setId(planetId);

            PersonEntity personEntity = new PersonEntity();
            personEntity.setId(personId);

            PlanetPersonEntity planetPersonEntity = new PlanetPersonEntity();
            planetPersonEntity.setId(planetPersonIdEntity);
            planetPersonEntity.setPlanet(planetEntity);
            planetPersonEntity.setPerson(personEntity);

            list.add(planetPersonEntity);
        }));
        return list;
    }
}
