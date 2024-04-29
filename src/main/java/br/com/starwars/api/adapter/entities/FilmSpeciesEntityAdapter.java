package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmPlanetEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmPlanetIdEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmSpeciesEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmSpeciesIdEntity;
import br.com.starwars.api.external.repository.starwars.entities.PlanetEntity;
import br.com.starwars.api.external.repository.starwars.entities.SpeciesEntity;
import br.com.starwars.api.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class FilmSpeciesEntityAdapter {


    public List<FilmSpeciesEntity> convert(List<Film> films){
        List<FilmSpeciesEntity> list = new ArrayList<>();
        films.stream().parallel().forEach(film -> film.getSpecies().stream().parallel().forEach(species -> {

            var speciesId = Integer.parseInt(StringUtils.extractValueFromURL(species.getUrl()));
            var fimId = film.getEpisodeId();

            FilmSpeciesIdEntity filmSpeciesIdEntity = new FilmSpeciesIdEntity();
            filmSpeciesIdEntity.setFilmId(fimId);
            filmSpeciesIdEntity.setSpeciesId(speciesId);

            FilmEntity filmEntity = new FilmEntity();
            filmEntity.setId(fimId);

            SpeciesEntity speciesEntity = new SpeciesEntity();
            speciesEntity.setId(speciesId);

            FilmSpeciesEntity filmPlanetEntity = new FilmSpeciesEntity();
            filmPlanetEntity.setId(filmSpeciesIdEntity);
            filmPlanetEntity.setFilm(filmEntity);
            filmPlanetEntity.setSpecies(speciesEntity);

            list.add(filmPlanetEntity);
        }));
        return list;
    }
}
