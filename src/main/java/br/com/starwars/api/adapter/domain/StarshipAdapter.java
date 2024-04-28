package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Species;
import br.com.starwars.api.domain.Starship;
import br.com.starwars.api.external.gateway.swapi.dto.SpeciesDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.StarshipDetailClientResponseDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class StarshipAdapter {

    public List<Starship> convert(List<StarshipDetailClientResponseDto> starshipDetailClientResponseDtos) {
        if ( starshipDetailClientResponseDtos == null ) {
            return null;
        }

        List<Starship> list = new ArrayList<Starship>( starshipDetailClientResponseDtos.size() );
        for ( StarshipDetailClientResponseDto starshipDetailClientResponseDto : starshipDetailClientResponseDtos ) {
            list.add( starshipDetailClientResponseDtoToStarship( starshipDetailClientResponseDto ) );
        }

        return list;
    }

    private Starship starshipDetailClientResponseDtoToStarship(StarshipDetailClientResponseDto starshipDetailClientResponseDto) {
        if ( starshipDetailClientResponseDto == null ) {
            return null;
        }

        Starship starship = new Starship();

        starship.setName( starshipDetailClientResponseDto.getName() );
        starship.setModel( starshipDetailClientResponseDto.getModel() );
        starship.setManufacturer( starshipDetailClientResponseDto.getManufacturer() );
        starship.setCostInCredits( starshipDetailClientResponseDto.getCostInCredits() );
        starship.setLength( starshipDetailClientResponseDto.getLength() );
        starship.setMaxAtmosphericSpeed( starshipDetailClientResponseDto.getMaxAtmosphericSpeed() );
        starship.setCrew( starshipDetailClientResponseDto.getCrew() );
        starship.setPassengers( starshipDetailClientResponseDto.getPassengers() );
        starship.setCargoCapacity( starshipDetailClientResponseDto.getCargoCapacity() );
        starship.setConsumables( starshipDetailClientResponseDto.getConsumables() );
        starship.setHyperdriveRating( starshipDetailClientResponseDto.getHyperdriveRating() );
        starship.setMglt( starshipDetailClientResponseDto.getMglt() );
        starship.setStarshipClass( starshipDetailClientResponseDto.getStarshipClass() );
        starship.setUrl( starshipDetailClientResponseDto.getUrl() );
        starship.setCreated( starshipDetailClientResponseDto.getCreated() );
        starship.setEdited( starshipDetailClientResponseDto.getEdited() );

        return starship;
    }

}
