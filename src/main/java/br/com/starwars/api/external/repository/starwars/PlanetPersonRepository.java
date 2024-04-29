package br.com.starwars.api.external.repository.starwars;

import br.com.starwars.api.external.repository.starwars.entities.PlanetPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetPersonRepository extends JpaRepository<PlanetPersonEntity, Integer> {
}
