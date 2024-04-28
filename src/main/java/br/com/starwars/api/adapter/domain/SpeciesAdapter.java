package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Species;
import br.com.starwars.api.external.gateway.swapi.dto.SpeciesDetailClientResponseDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class SpeciesAdapter {

    private final PlanetMapperAdapter planetMapperAdapter = PlanetMapperAdapter.INSTANCE;
    private final PersonMapperAdapter personMapperAdapter = PersonMapperAdapter.INSTANCE;
    private final FilmMapperAdapter filmMapperAdapter = FilmMapperAdapter.INSTANCE;

    public List<Species> convert(List<SpeciesDetailClientResponseDto> speciesDetailClientResponseDtos) {
        if ( speciesDetailClientResponseDtos == null ) {
            return null;
        }

        List<Species> list = new ArrayList<Species>( speciesDetailClientResponseDtos.size() );
        for ( SpeciesDetailClientResponseDto speciesDetailClientResponseDto : speciesDetailClientResponseDtos ) {
            list.add( speciesDetailClientResponseDtoToSpecies( speciesDetailClientResponseDto ) );
        }

        return list;
    }

    private Species speciesDetailClientResponseDtoToSpecies(SpeciesDetailClientResponseDto speciesDetailClientResponseDto) {
        if ( speciesDetailClientResponseDto == null ) {
            return null;
        }

        Species species = new Species();

        species.setName( speciesDetailClientResponseDto.getName() );
        species.setClassification( speciesDetailClientResponseDto.getClassification() );
        species.setDesignation( speciesDetailClientResponseDto.getDesignation() );
        species.setAverageHeight( speciesDetailClientResponseDto.getAverageHeight() );
        species.setSkinColors( speciesDetailClientResponseDto.getSkinColors() );
        species.setHairColors( speciesDetailClientResponseDto.getHairColors() );
        species.setEyeColors( speciesDetailClientResponseDto.getEyeColors() );
        species.setAverageLifespan( speciesDetailClientResponseDto.getAverageLifespan() );
        species.setHomeworld( planetMapperAdapter.map( speciesDetailClientResponseDto.getHomeworld() ) );
        species.setLanguage( speciesDetailClientResponseDto.getLanguage() );
        species.setPeople( personMapperAdapter.map( speciesDetailClientResponseDto.getPeople() ) );
        species.setFilms( filmMapperAdapter.map( speciesDetailClientResponseDto.getFilms() ) );
        species.setCreated( speciesDetailClientResponseDto.getCreated() );
        species.setEdited( speciesDetailClientResponseDto.getEdited() );
        species.setUrl( speciesDetailClientResponseDto.getUrl() );

        return species;
    }

}
