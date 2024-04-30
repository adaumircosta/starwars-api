package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class FilmPersonAdapter {


    public void convert(List<Film> films) {
        List<Film> list = new ArrayList<>();
        films.stream().parallel().forEach(film -> film.getCharacters().stream().parallel().forEach(person -> {

            var personId = Integer.parseInt(StringUtils.extractValueFromURL(person.getUrl()));
            var fimId = film.getEpisodeId();

            film.setId(fimId);
            person.setId(personId);
        }));
    }
}
