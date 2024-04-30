package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Planet;
import br.com.starwars.api.external.gateway.swapi.dto.PlanetDetailClientResponseDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface PlanetMapperAdapter {

    PlanetMapperAdapter INSTANCE = Mappers.getMapper(PlanetMapperAdapter.class);

    List<Planet> map(List<String> value);

    @Mapping(target = "url", source = "value")
    Planet map(String value);

    List<Planet> convert(List<PlanetDetailClientResponseDto> list);
}
