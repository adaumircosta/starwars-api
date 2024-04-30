package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Species;
import br.com.starwars.api.external.gateway.swapi.dto.SpeciesDetailClientResponseDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), uses = {PlanetMapperAdapter.class})
public interface SpeciesMapperAdapter {

    SpeciesMapperAdapter INSTANCE = Mappers.getMapper(SpeciesMapperAdapter.class);

    List<Species> map(List<String> value);

    @Mapping(target = "url", source = "value")
    Species map(String value);

    List<Species> convert(List<SpeciesDetailClientResponseDto> list);
}
