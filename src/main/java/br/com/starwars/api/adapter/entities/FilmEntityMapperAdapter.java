package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface FilmEntityMapperAdapter {

    FilmEntityMapperAdapter INSTANCE = Mappers.getMapper(FilmEntityMapperAdapter.class);

    List<FilmEntity> convert(List<Film> films);

    @Mapping(target = "version", expression = "java(1)")
    FilmEntity convert(Film film);


}
