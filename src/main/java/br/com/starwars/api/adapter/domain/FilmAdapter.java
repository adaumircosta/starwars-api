package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.external.gateway.swapi.dto.FilmDetailClientResponseDto;
import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
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

    public List<Film> convertToFilm(List<FilmEntity> filmEntityList) {
        if (filmEntityList == null) {
            return null;
        }

        List<Film> list = new ArrayList<>(filmEntityList.size());
        for (FilmEntity filmEntity : filmEntityList) {
            list.add(filmEntityToFilm(filmEntity));
        }

        return list;
    }

    public Film filmEntityToFilm(FilmEntity filmEntity) {
        if ( filmEntity == null ) {
            return null;
        }

        Film film = new Film();

        film.setTitle( filmEntity.getTitle() );
        film.setEpisodeId( filmEntity.getEpisodeId() );
        film.setOpeningCrawl( filmEntity.getOpeningCrawl() );
        film.setDirector( filmEntity.getDirector() );
        film.setProducer( filmEntity.getProducer() );
        film.setReleaseDate( filmEntity.getReleaseDate() );
        film.setCreated( filmEntity.getCreated() );
        film.setEdited( filmEntity.getEdited() );
        film.setUrl( filmEntity.getUrl() );
        film.setVersion(filmEntity.getVersion());

        return film;
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
