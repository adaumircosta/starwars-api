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
public class PersonVehicleIdEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1803078004219017135L;

    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @Column(name = "vehicle_id", nullable = false)
    private Integer vehicleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonVehicleIdEntity entity = (PersonVehicleIdEntity) o;
        return Objects.equals(this.personId, entity.personId) &&
                Objects.equals(this.vehicleId, entity.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, vehicleId);
    }

}