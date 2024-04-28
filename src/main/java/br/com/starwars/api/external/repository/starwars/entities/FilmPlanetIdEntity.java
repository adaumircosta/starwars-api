package br.com.starwars.api.external.repository.starwars.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Embeddable
public class FilmPlanetIdEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1332535711635682652L;

    @Column(name = "film_id", nullable = false)
    private Integer filmId;

    @Column(name = "planet_id", nullable = false)
    private Integer planetId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmPlanetIdEntity entity = (FilmPlanetIdEntity) o;
        return Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.planetId, entity.planetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, planetId);
    }

}