package br.com.starwars.api.external.repository.starwars;

import br.com.starwars.api.external.repository.starwars.entities.PersonSpeciesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonSpeciesRepository extends JpaRepository<PersonSpeciesEntity, Integer> {
}
