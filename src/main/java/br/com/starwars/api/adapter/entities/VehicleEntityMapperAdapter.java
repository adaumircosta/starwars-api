package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Vehicle;
import br.com.starwars.api.external.repository.starwars.entities.VehicleEntity;
import br.com.starwars.api.utils.StringUtils;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), imports = {StringUtils.class})
public interface VehicleEntityMapperAdapter {

    VehicleEntityMapperAdapter INSTANCE = Mappers.getMapper(VehicleEntityMapperAdapter.class);

    List<VehicleEntity> convert(List<Vehicle> vehicles);

    @Mapping(target = "id", expression = "java(Integer.parseInt(StringUtils.extractValueFromURL(vehicle.getUrl())))")
    VehicleEntity convert(Vehicle vehicle);
}
