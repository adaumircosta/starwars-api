package br.com.starwars.api.external.repository.starwars.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class FilmPersonIdEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -6436829899144787275L;

    @Column(name = "film_id", nullable = false)
    private Integer filmId;

    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmPersonIdEntity entity = (FilmPersonIdEntity) o;
        return Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.personId, entity.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, personId);
    }

}