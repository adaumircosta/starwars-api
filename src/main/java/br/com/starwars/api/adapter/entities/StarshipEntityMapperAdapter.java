package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Starship;
import br.com.starwars.api.external.repository.starwars.entities.StarshipEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface StarshipEntityMapperAdapter {

    StarshipEntityMapperAdapter INSTANCE = Mappers.getMapper(StarshipEntityMapperAdapter.class);

    List<StarshipEntity> convert(List<Starship> films);
}
