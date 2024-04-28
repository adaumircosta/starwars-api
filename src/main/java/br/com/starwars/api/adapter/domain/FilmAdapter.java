package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.external.gateway.swapi.dto.FilmDetailClientResponseDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class FilmAdapter {

    private final PersonMapperAdapter personMapperAdapter = PersonMapperAdapter.INSTANCE;
    private final PlanetMapperAdapter planetMapperAdapter = PlanetMapperAdapter.INSTANCE;
    private final StarshipMapperAdapter starshipMapperAdapter = StarshipMapperAdapter.INSTANCE;
    private final VehicleMapperAdapter vehicleMapperAdapter = VehicleMapperAdapter.INSTANCE;
    private final SpeciesMapperAdapter speciesMapperAdapter = SpeciesMapperAdapter.INSTANCE;

    public List<Film> convert(List<FilmDetailClientResponseDto> filmDetailClientResponseDto) {
        if (filmDetailClientResponseDto == null) {
            return null;
        }

        List<Film> list = new ArrayList<Film>(filmDetailClientResponseDto.size());
        for (FilmDetailClientResponseDto filmDetailClientResponseDto1 : filmDetailClientResponseDto) {
            list.add(filmDetailClientResponseDtoToFilm(filmDetailClientResponseDto1));
        }

        return list;
    }

    private Film filmDetailClientResponseDtoToFilm(FilmDetailClientResponseDto filmDetailClientResponseDto) {
        if ( filmDetailClientResponseDto == null ) {
            return null;
        }

        Film film = new Film();

        film.setTitle( filmDetailClientResponseDto.getTitle() );
        film.setEpisodeId( filmDetailClientResponseDto.getEpisodeId() );
        film.setOpeningCrawl( filmDetailClientResponseDto.getOpeningCrawl() );
        film.setDirector( filmDetailClientResponseDto.getDirector() );
        film.setProducer( filmDetailClientResponseDto.getProducer() );
        film.setReleaseDate( filmDetailClientResponseDto.getReleaseDate() );
        film.setCharacters( personMapperAdapter.map( filmDetailClientResponseDto.getCharacters() ) );
        film.setPlanets( planetMapperAdapter.map( filmDetailClientResponseDto.getPlanets() ) );
        film.setStarships( starshipMapperAdapter.map( filmDetailClientResponseDto.getStarships() ) );
        film.setVehicles( vehicleMapperAdapter.map( filmDetailClientResponseDto.getVehicles() ) );
        film.setSpecies( speciesMapperAdapter.map( filmDetailClientResponseDto.getSpecies() ) );
        film.setCreated( filmDetailClientResponseDto.getCreated() );
        film.setEdited( filmDetailClientResponseDto.getEdited() );
        film.setUrl( filmDetailClientResponseDto.getUrl() );

        return film;
    }

}
