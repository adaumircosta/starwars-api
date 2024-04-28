package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Planet;
import br.com.starwars.api.external.gateway.swapi.dto.PlanetDetailClientResponseDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class PlanetAdapter {

    private final PersonMapperAdapter personMapperAdapter = PersonMapperAdapter.INSTANCE;
    private final FilmMapperAdapter filmMapperAdapter = FilmMapperAdapter.INSTANCE;

    public List<Planet> convert(List<PlanetDetailClientResponseDto> planetDetailClientResponseDtos) {
        if ( planetDetailClientResponseDtos == null ) {
            return null;
        }

        List<Planet> list = new ArrayList<Planet>( planetDetailClientResponseDtos.size() );
        for ( PlanetDetailClientResponseDto planetDetailClientResponseDto : planetDetailClientResponseDtos ) {
            list.add( planetDetailClientResponseDtoToPlanet( planetDetailClientResponseDto ) );
        }

        return list;
    }

    private Planet planetDetailClientResponseDtoToPlanet(PlanetDetailClientResponseDto planetDetailClientResponseDto) {
        if ( planetDetailClientResponseDto == null ) {
            return null;
        }

        Planet planet = new Planet();

        planet.setName( planetDetailClientResponseDto.getName() );
        planet.setRotationPeriod( planetDetailClientResponseDto.getRotationPeriod() );
        planet.setOrbitalPeriod( planetDetailClientResponseDto.getOrbitalPeriod() );
        planet.setDiameter( planetDetailClientResponseDto.getDiameter() );
        planet.setClimate( planetDetailClientResponseDto.getClimate() );
        planet.setGravity( planetDetailClientResponseDto.getGravity() );
        planet.setTerrain( planetDetailClientResponseDto.getTerrain() );
        planet.setSurfaceWater( planetDetailClientResponseDto.getSurfaceWater() );
        planet.setPopulation( planetDetailClientResponseDto.getPopulation() );
        planet.setResidents( personMapperAdapter.map( planetDetailClientResponseDto.getResidents() ) );
        planet.setFilms( filmMapperAdapter.map( planetDetailClientResponseDto.getFilms() ) );
        planet.setCreated( planetDetailClientResponseDto.getCreated() );
        planet.setEdited( planetDetailClientResponseDto.getEdited() );
        planet.setUrl( planetDetailClientResponseDto.getUrl() );

        return planet;
    }

}
