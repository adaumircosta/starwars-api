package br.com.starwars.api.external.repository.starwars.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class FilmSpeciesIdEntity implements Serializable {

    private static final long serialVersionUID = -3660079071030698656L;

    @Column(name = "film_id", nullable = false)
    private Integer filmId;

    @Column(name = "species_id", nullable = false)
    private Integer speciesId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmSpeciesIdEntity entity = (FilmSpeciesIdEntity) o;
        return Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.speciesId, entity.speciesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, speciesId);
    }

}