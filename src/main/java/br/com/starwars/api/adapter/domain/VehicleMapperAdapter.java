package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Vehicle;
import br.com.starwars.api.external.gateway.swapi.dto.VehicleDetailClientResponseDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface VehicleMapperAdapter {

    VehicleMapperAdapter INSTANCE = Mappers.getMapper(VehicleMapperAdapter.class);

    List<Vehicle> map(List<String> value);

    @Mapping(target = "url", source = "value")
    Vehicle map(String value);

}
