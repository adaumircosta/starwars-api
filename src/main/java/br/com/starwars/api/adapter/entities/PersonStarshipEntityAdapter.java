package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Person;
import br.com.starwars.api.external.repository.starwars.entities.PersonEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonStarshipEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonStarshipIdEntity;
import br.com.starwars.api.external.repository.starwars.entities.StarshipEntity;
import br.com.starwars.api.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class PersonStarshipEntityAdapter {


    public List<PersonStarshipEntity> convert(List<Person> people){
        List<PersonStarshipEntity> list = new ArrayList<>();
        people.stream().parallel().forEach(person -> person.getStarships().stream().parallel().forEach(starship -> {

            var personId = Integer.parseInt(StringUtils.extractValueFromURL(person.getUrl()));
            var starshipId = Integer.parseInt(StringUtils.extractValueFromURL(starship.getUrl()));

            PersonStarshipIdEntity personStarshipIdEntity = new PersonStarshipIdEntity();
            personStarshipIdEntity.setPersonId(personId);
            personStarshipIdEntity.setStarshipId(starshipId);

            PersonEntity personEntity = new PersonEntity();
            personEntity.setId(personId);

            StarshipEntity starshipEntity = new StarshipEntity();
            starshipEntity.setId(starshipId);

            PersonStarshipEntity personStarshipEntity = new PersonStarshipEntity();
            personStarshipEntity.setId(personStarshipIdEntity);
            personStarshipEntity.setPerson(personEntity);
            personStarshipEntity.setStarship(starshipEntity);

            list.add(personStarshipEntity);
        }));
        return list;
    }
}
