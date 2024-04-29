package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Starship;
import br.com.starwars.api.external.repository.starwars.entities.StarshipEntity;
import br.com.starwars.api.utils.StringUtils;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), imports = {StringUtils.class})
public interface StarshipEntityMapperAdapter {

    StarshipEntityMapperAdapter INSTANCE = Mappers.getMapper(StarshipEntityMapperAdapter.class);

    List<StarshipEntity> convert(List<Starship> starships);

    @Mapping(target = "id", expression = "java(Integer.parseInt(StringUtils.extractValueFromURL(starship.getUrl())))")
    StarshipEntity convert(Starship starship);
}
