package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Planet;
import br.com.starwars.api.external.repository.starwars.entities.PlanetEntity;
import br.com.starwars.api.utils.StringUtils;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), imports = {StringUtils.class})
public interface PlanetEntityMapperAdapter {

    PlanetEntityMapperAdapter INSTANCE = Mappers.getMapper(PlanetEntityMapperAdapter.class);

    List<PlanetEntity> convert(List<Planet> planets);

    @Mapping(target = "id", expression = "java(Integer.parseInt(StringUtils.extractValueFromURL(planet.getUrl())))")
    PlanetEntity convert(Planet planet);
}
