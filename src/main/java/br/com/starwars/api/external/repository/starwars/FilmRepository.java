package br.com.starwars.api.external.repository.starwars;

import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import feign.Param;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {

    List<FilmEntity> findAll();
    FilmEntity findByEpisodeId(Integer episodeId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE FilmEntity f SET f.openingCrawl = :description, f.version = f.version +1 WHERE f.episodeId = :episodeId")
    int updateDescription(@Param("episodeId") Integer episodeId, @Param("description") String description);
}
