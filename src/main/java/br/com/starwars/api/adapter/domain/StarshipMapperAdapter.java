package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Starship;
import br.com.starwars.api.external.gateway.swapi.dto.StarshipDetailClientResponseDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface StarshipMapperAdapter {

    StarshipMapperAdapter INSTANCE = Mappers.getMapper(StarshipMapperAdapter.class);

    List<Starship> map(List<String> value);

    @Mapping(target = "url", source = "value")
    Starship map(String value);

    List<Starship> convert(List<StarshipDetailClientResponseDto> list);
}
