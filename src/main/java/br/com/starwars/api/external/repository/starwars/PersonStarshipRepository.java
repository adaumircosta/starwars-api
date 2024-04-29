package br.com.starwars.api.external.repository.starwars;

import br.com.starwars.api.external.repository.starwars.entities.PersonStarshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonStarshipRepository extends JpaRepository<PersonStarshipEntity, Integer> {
}
