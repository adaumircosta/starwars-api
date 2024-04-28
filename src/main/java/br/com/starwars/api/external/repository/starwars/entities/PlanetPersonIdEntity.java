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
public class PlanetPersonIdEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -7576716074451188900L;

    @Column(name = "planet_id", nullable = false)
    private Integer planetId;

    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlanetPersonIdEntity entity = (PlanetPersonIdEntity) o;
        return Objects.equals(this.personId, entity.personId) &&
                Objects.equals(this.planetId, entity.planetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, planetId);
    }

}