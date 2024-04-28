package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Planet;
import br.com.starwars.api.external.repository.starwars.entities.PlanetEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface PlanetEntityMapperAdapter {

    PlanetEntityMapperAdapter INSTANCE = Mappers.getMapper(PlanetEntityMapperAdapter.class);

    List<PlanetEntity> convert(List<Planet> films);
}
