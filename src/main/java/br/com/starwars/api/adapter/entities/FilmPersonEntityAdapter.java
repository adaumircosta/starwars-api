package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmPersonEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmPersonIdEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonEntity;
import br.com.starwars.api.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class FilmPersonEntityAdapter {


    public List<FilmPersonEntity> convert(List<Film> films){
        List<FilmPersonEntity> list = new ArrayList<>();
        films.stream().parallel().forEach(film -> film.getCharacters().stream().parallel().forEach(person -> {

            var personId = Integer.parseInt(StringUtils.extractValueFromURL(person.getUrl()));
            var fimId = film.getEpisodeId();

            FilmPersonIdEntity filmPersonIdEntity = new FilmPersonIdEntity();
            filmPersonIdEntity.setFilmId(fimId);
            filmPersonIdEntity.setPersonId(personId);

            FilmEntity filmEntity = new FilmEntity();
            filmEntity.setId(fimId);

            PersonEntity personEntity = new PersonEntity();
            personEntity.setId(personId);

            FilmPersonEntity filmPersonEntity = new FilmPersonEntity();
            filmPersonEntity.setId(filmPersonIdEntity);
            filmPersonEntity.setFilm(filmEntity);
            filmPersonEntity.setPerson(personEntity);

            list.add(filmPersonEntity);
        }));
        return list;
    }
}
