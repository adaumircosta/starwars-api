package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmStarshipEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmStarshipIdEntity;
import br.com.starwars.api.external.repository.starwars.entities.StarshipEntity;
import br.com.starwars.api.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class FilmStarshipEntityAdapter {


    public List<FilmStarshipEntity> convert(List<Film> films){
        List<FilmStarshipEntity> list = new ArrayList<>();
        films.stream().parallel().forEach(film -> film.getStarships().stream().parallel().forEach(starship -> {

            var starshipId = Integer.parseInt(StringUtils.extractValueFromURL(starship.getUrl()));
            var fimId = film.getEpisodeId();

            FilmStarshipIdEntity filmStarshipIdEntity = new FilmStarshipIdEntity();
            filmStarshipIdEntity.setFilmId(fimId);
            filmStarshipIdEntity.setStarshipId(starshipId);

            FilmEntity filmEntity = new FilmEntity();
            filmEntity.setId(fimId);

            StarshipEntity starshipEntity = new StarshipEntity();
            starshipEntity.setId(starshipId);

            FilmStarshipEntity filmStarshipEntity = new FilmStarshipEntity();
            filmStarshipEntity.setId(filmStarshipIdEntity);
            filmStarshipEntity.setFilm(filmEntity);
            filmStarshipEntity.setStarship(starshipEntity);

            list.add(filmStarshipEntity);
        }));
        return list;
    }
}
