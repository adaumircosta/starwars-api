package br.com.starwars.api.external.repository.starwars.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class FilmStarshipIdEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -4309638818706602177L;

    @Column(name = "film_id", nullable = false)
    private Integer filmId;

    @Column(name = "starship_id", nullable = false)
    private Integer starshipId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmStarshipIdEntity entity = (FilmStarshipIdEntity) o;
        return Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.starshipId, entity.starshipId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, starshipId);
    }

}