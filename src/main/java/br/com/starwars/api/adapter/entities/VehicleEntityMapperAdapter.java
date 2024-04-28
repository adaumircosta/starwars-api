package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Vehicle;
import br.com.starwars.api.external.repository.starwars.entities.VehicleEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface VehicleEntityMapperAdapter {

    VehicleEntityMapperAdapter INSTANCE = Mappers.getMapper(VehicleEntityMapperAdapter.class);

    List<VehicleEntity> convert(List<Vehicle> films);
}
