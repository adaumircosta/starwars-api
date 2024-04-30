package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.external.gateway.swapi.dto.FilmDetailClientResponseDto;
import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true),
        uses = {PersonMapperAdapter.class, PlanetMapperAdapter.class, StarshipMapperAdapter.class, VehicleMapperAdapter.class, SpeciesMapperAdapter.class})
public interface FilmMapperAdapter {

    FilmMapperAdapter INSTANCE = Mappers.getMapper(FilmMapperAdapter.class);

    List<Film> convertList(List<FilmEntity> list);

    Film convert(FilmEntity filmEntity);

    List<Film> convert(List<FilmDetailClientResponseDto> list);

    List<Film> map(List<String> value);

    @Mapping(target = "url", source = "value")
    Film map(String value);

}
