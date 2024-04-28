package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Starship;
import br.com.starwars.api.domain.Vehicle;
import br.com.starwars.api.external.gateway.swapi.dto.StarshipDetailClientResponseDto;
import br.com.starwars.api.external.gateway.swapi.dto.VehicleDetailClientResponseDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class VehicleAdapter {

    private final PersonMapperAdapter personMapperAdapter = PersonMapperAdapter.INSTANCE;
    private final FilmMapperAdapter filmMapperAdapter = FilmMapperAdapter.INSTANCE;

    public List<Vehicle> convert(List<VehicleDetailClientResponseDto> vehicleDetailClientResponseDtos) {
        if ( vehicleDetailClientResponseDtos == null ) {
            return null;
        }

        List<Vehicle> list = new ArrayList<Vehicle>( vehicleDetailClientResponseDtos.size() );
        for ( VehicleDetailClientResponseDto vehicleDetailClientResponseDto : vehicleDetailClientResponseDtos ) {
            list.add( vehicleDetailClientResponseDtoToVehicle( vehicleDetailClientResponseDto ) );
        }

        return list;
    }

    protected Vehicle vehicleDetailClientResponseDtoToVehicle(VehicleDetailClientResponseDto vehicleDetailClientResponseDto) {
        if ( vehicleDetailClientResponseDto == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setName( vehicleDetailClientResponseDto.getName() );
        vehicle.setModel( vehicleDetailClientResponseDto.getModel() );
        vehicle.setManufacturer( vehicleDetailClientResponseDto.getManufacturer() );
        vehicle.setCostInCredits( vehicleDetailClientResponseDto.getCostInCredits() );
        vehicle.setLength( vehicleDetailClientResponseDto.getLength() );
        vehicle.setMaxAtmosphericSpeed( vehicleDetailClientResponseDto.getMaxAtmosphericSpeed() );
        vehicle.setCrew( vehicleDetailClientResponseDto.getCrew() );
        vehicle.setPassengers( vehicleDetailClientResponseDto.getPassengers() );
        vehicle.setCargoCapacity( vehicleDetailClientResponseDto.getCargoCapacity() );
        vehicle.setConsumables( vehicleDetailClientResponseDto.getConsumables() );
        vehicle.setVehicleClass( vehicleDetailClientResponseDto.getVehicleClass() );
        vehicle.setPilots(personMapperAdapter.map(vehicleDetailClientResponseDto.getPilots()));
        vehicle.setFilms(filmMapperAdapter.map(vehicleDetailClientResponseDto.getFilms()));
        vehicle.setUrl( vehicleDetailClientResponseDto.getUrl() );
        vehicle.setCreated( vehicleDetailClientResponseDto.getCreated() );
        vehicle.setEdited( vehicleDetailClientResponseDto.getEdited() );

        return vehicle;
    }

}
