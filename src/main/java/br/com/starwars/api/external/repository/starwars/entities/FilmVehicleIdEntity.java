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
public class FilmVehicleIdEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 5006771333163264230L;

    @Column(name = "film_id", nullable = false)
    private Integer filmId;

    @Column(name = "vehicle_id", nullable = false)
    private Integer vehicleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmVehicleIdEntity entity = (FilmVehicleIdEntity) o;
        return Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.vehicleId, entity.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, vehicleId);
    }

}