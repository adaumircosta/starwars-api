package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Person;
import br.com.starwars.api.external.gateway.swapi.dto.PersonDetailClientResponseDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class PersonAdapter {

    private final PlanetMapperAdapter planetMapperAdapter = PlanetMapperAdapter.INSTANCE;
    private final FilmMapperAdapter filmMapperAdapter = FilmMapperAdapter.INSTANCE;
    private final SpeciesMapperAdapter speciesMapperAdapter = SpeciesMapperAdapter.INSTANCE;
    private final VehicleMapperAdapter vehicleMapperAdapter = VehicleMapperAdapter.INSTANCE;
    private final StarshipMapperAdapter starshipMapperAdapter = StarshipMapperAdapter.INSTANCE;

    public List<Person> convert(List<PersonDetailClientResponseDto> personDetailClientResponseDtos) {
        if ( personDetailClientResponseDtos == null ) {
            return null;
        }

        List<Person> list = new ArrayList<Person>( personDetailClientResponseDtos.size() );
        for ( PersonDetailClientResponseDto personDetailClientResponseDto : personDetailClientResponseDtos ) {
            list.add( personDetailClientResponseDtoToPerson( personDetailClientResponseDto ) );
        }

        return list;
    }

    private Person personDetailClientResponseDtoToPerson(PersonDetailClientResponseDto personDetailClientResponseDto) {
        if ( personDetailClientResponseDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setName( personDetailClientResponseDto.getName() );
        person.setHeight( personDetailClientResponseDto.getHeight() );
        person.setMass( personDetailClientResponseDto.getMass() );
        person.setHairColor( personDetailClientResponseDto.getHairColor() );
        person.setSkinColor( personDetailClientResponseDto.getSkinColor() );
        person.setEyeColor( personDetailClientResponseDto.getEyeColor() );
        person.setBirthYear( personDetailClientResponseDto.getBirthYear() );
        person.setGender( personDetailClientResponseDto.getGender() );
        person.setHomeworld( planetMapperAdapter.map( personDetailClientResponseDto.getHomeworld() ) );
        person.setFilms( filmMapperAdapter.map( personDetailClientResponseDto.getFilms() ) );
        person.setSpecies( speciesMapperAdapter.map( personDetailClientResponseDto.getSpecies() ) );
        person.setVehicles( vehicleMapperAdapter.map( personDetailClientResponseDto.getVehicles() ) );
        person.setStarships( starshipMapperAdapter.map( personDetailClientResponseDto.getStarships() ) );
        person.setCreated( personDetailClientResponseDto.getCreated() );
        person.setEdited( personDetailClientResponseDto.getEdited() );
        person.setUrl( personDetailClientResponseDto.getUrl() );

        return person;
    }

}
