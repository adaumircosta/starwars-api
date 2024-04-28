package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Species;
import br.com.starwars.api.external.repository.starwars.entities.SpeciesEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface SpeciesEntityMapperAdapter {

    SpeciesEntityMapperAdapter INSTANCE = Mappers.getMapper(SpeciesEntityMapperAdapter.class);

    List<SpeciesEntity> convert(List<Species> films);
}
