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
public class PersonStarshipIdEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1696806040530221837L;

    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @Column(name = "starship_id", nullable = false)
    private Integer starshipId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonStarshipIdEntity entity = (PersonStarshipIdEntity) o;
        return Objects.equals(this.starshipId, entity.starshipId) &&
                Objects.equals(this.personId, entity.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(starshipId, personId);
    }

}