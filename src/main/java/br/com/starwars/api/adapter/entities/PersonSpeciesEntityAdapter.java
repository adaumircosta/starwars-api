package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Person;
import br.com.starwars.api.external.repository.starwars.entities.PersonEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonSpeciesEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonSpeciesIdEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonVehicleEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonVehicleIdEntity;
import br.com.starwars.api.external.repository.starwars.entities.SpeciesEntity;
import br.com.starwars.api.external.repository.starwars.entities.VehicleEntity;
import br.com.starwars.api.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class PersonSpeciesEntityAdapter {


    public List<PersonSpeciesEntity> convert(List<Person> people){
        List<PersonSpeciesEntity> list = new ArrayList<>();
        people.stream().parallel().forEach(person -> person.getSpecies().stream().parallel().forEach(species -> {

            var personId = Integer.parseInt(StringUtils.extractValueFromURL(person.getUrl()));
            var speciesId = Integer.parseInt(StringUtils.extractValueFromURL(species.getUrl()));

            PersonSpeciesIdEntity personSpeciesIdEntity = new PersonSpeciesIdEntity();
            personSpeciesIdEntity.setPersonId(personId);
            personSpeciesIdEntity.setSpeciesId(speciesId);

            PersonEntity personEntity = new PersonEntity();
            personEntity.setId(personId);

            SpeciesEntity speciesEntity = new SpeciesEntity();
            speciesEntity.setId(speciesId);

            PersonSpeciesEntity personSpeciesEntity = new PersonSpeciesEntity();
            personSpeciesEntity.setId(personSpeciesIdEntity);
            personSpeciesEntity.setPerson(personEntity);
            personSpeciesEntity.setSpecies(speciesEntity);

            list.add(personSpeciesEntity);
        }));
        return list;
    }
}
