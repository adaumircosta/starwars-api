package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmVehicleEntity;
import br.com.starwars.api.external.repository.starwars.entities.FilmVehicleIdEntity;
import br.com.starwars.api.external.repository.starwars.entities.VehicleEntity;
import br.com.starwars.api.utils.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class FilmVehicleEntityAdapter {


    public List<FilmVehicleEntity> convert(List<Film> films){
        List<FilmVehicleEntity> list = new ArrayList<>();
        films.stream().parallel().forEach(film -> film.getVehicles().stream().parallel().forEach(vehicle -> {

            var vehicleId = Integer.parseInt(StringUtils.extractValueFromURL(vehicle.getUrl()));
            var fimId = film.getEpisodeId();

            FilmVehicleIdEntity filmVehicleIdEntity = new FilmVehicleIdEntity();
            filmVehicleIdEntity.setFilmId(fimId);
            filmVehicleIdEntity.setVehicleId(vehicleId);

            FilmEntity filmEntity = new FilmEntity();
            filmEntity.setId(fimId);

            VehicleEntity vehicleEntity = new VehicleEntity();
            vehicleEntity.setId(vehicleId);

            FilmVehicleEntity filmVehicleEntity = new FilmVehicleEntity();
            filmVehicleEntity.setId(filmVehicleIdEntity);
            filmVehicleEntity.setFilm(filmEntity);
            filmVehicleEntity.setVehicle(vehicleEntity);

            list.add(filmVehicleEntity);
        }));
        return list;
    }
}
