package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmPlanetEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmPlanetIdEntity;
import br.com.starwars.api.external.repository.starwars.entities.PlanetEntity;
import br.com.starwars.api.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class FilmPlanetEntityAdapter {


    public List<FilmPlanetEntity> convert(List<Film> films){
        List<FilmPlanetEntity> list = new ArrayList<>();
        films.stream().parallel().forEach(film -> film.getPlanets().stream().parallel().forEach(planet -> {

            var planetId = Integer.parseInt(StringUtils.extractValueFromURL(planet.getUrl()));
            var fimId = film.getEpisodeId();

            FilmPlanetIdEntity filmPlanetIdEntity = new FilmPlanetIdEntity();
            filmPlanetIdEntity.setFilmId(fimId);
            filmPlanetIdEntity.setPlanetId(planetId);

            FilmEntity filmEntity = new FilmEntity();
            filmEntity.setId(fimId);

            PlanetEntity planetEntity = new PlanetEntity();
            planetEntity.setId(planetId);

            FilmPlanetEntity filmPlanetEntity = new FilmPlanetEntity();
            filmPlanetEntity.setId(filmPlanetIdEntity);
            filmPlanetEntity.setFilm(filmEntity);
            filmPlanetEntity.setPlanet(planetEntity);

            list.add(filmPlanetEntity);
        }));
        return list;
    }
}
