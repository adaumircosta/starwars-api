package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Person;
import br.com.starwars.api.external.repository.starwars.entities.PersonEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonVehicleEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonVehicleIdEntity;
import br.com.starwars.api.external.repository.starwars.entities.VehicleEntity;
import br.com.starwars.api.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class PersonVehicleEntityAdapter {


    public List<PersonVehicleEntity> convert(List<Person> people){
        List<PersonVehicleEntity> list = new ArrayList<>();
        people.stream().parallel().forEach(person -> person.getVehicles().stream().parallel().forEach(vehicle -> {

            var personId = Integer.parseInt(StringUtils.extractValueFromURL(person.getUrl()));
            var vehicleId = Integer.parseInt(StringUtils.extractValueFromURL(vehicle.getUrl()));

            PersonVehicleIdEntity personVehicleIdEntity = new PersonVehicleIdEntity();
            personVehicleIdEntity.setPersonId(personId);
            personVehicleIdEntity.setVehicleId(vehicleId);

            PersonEntity personEntity = new PersonEntity();
            personEntity.setId(personId);

            VehicleEntity vehicleEntity = new VehicleEntity();
            vehicleEntity.setId(vehicleId);

            PersonVehicleEntity personVehicleEntity = new PersonVehicleEntity();
            personVehicleEntity.setId(personVehicleIdEntity);
            personVehicleEntity.setPerson(personEntity);
            personVehicleEntity.setVehicle(vehicleEntity);

            list.add(personVehicleEntity);
        }));
        return list;
    }
}
