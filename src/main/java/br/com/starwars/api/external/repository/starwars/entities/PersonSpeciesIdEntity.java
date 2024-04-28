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
public class PersonSpeciesIdEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 3289700110680726030L;

    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @Column(name = "species_id", nullable = false)
    private Integer speciesId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonSpeciesIdEntity entity = (PersonSpeciesIdEntity) o;
        return Objects.equals(this.personId, entity.personId) &&
                Objects.equals(this.speciesId, entity.speciesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, speciesId);
    }

}