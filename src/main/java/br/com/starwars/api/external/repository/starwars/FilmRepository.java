package br.com.starwars.api.external.repository.starwars;

import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {

    List<FilmEntity> findAll();
    FilmEntity findByEpisodeId(Integer episodeId);

    @Query(value = "select f from film f " +
            "inner join f.person pe " +
            "inner join f.planet pl " +
            "inner join f.starships ss " +
            "inner join f.vehicles vh " +
            "inner join f.species sp " +
            "inner join ")
    FilmEntity findDetailsByEpisodeId(Integer episodeId);
}
