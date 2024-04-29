package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Species;
import br.com.starwars.api.external.repository.starwars.entities.SpeciesEntity;
import br.com.starwars.api.utils.StringUtils;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), imports = {StringUtils.class})
public interface SpeciesEntityMapperAdapter {

    SpeciesEntityMapperAdapter INSTANCE = Mappers.getMapper(SpeciesEntityMapperAdapter.class);

    List<SpeciesEntity> convert(List<Species> species);

    @Mapping(target = "id", expression = "java(Integer.parseInt(StringUtils.extractValueFromURL(species.getUrl())))")
    @Mapping(target = "homeworld.id", expression = "java(Integer.parseInt(StringUtils.extractValueFromURL(planet.getUrl())))")
    SpeciesEntity convert(Species species);
}
