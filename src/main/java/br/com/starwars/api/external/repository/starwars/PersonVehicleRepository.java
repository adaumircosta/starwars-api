package br.com.starwars.api.external.repository.starwars;

import br.com.starwars.api.external.repository.starwars.entities.PersonVehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonVehicleRepository extends JpaRepository<PersonVehicleEntity, Integer> {
}
