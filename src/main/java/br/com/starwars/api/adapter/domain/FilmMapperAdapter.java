package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Film;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface FilmMapperAdapter {

    FilmMapperAdapter INSTANCE = Mappers.getMapper(FilmMapperAdapter.class);


    List<Film> map(List<String> value);

    @Mapping(target = "url", source = "value")
    Film map(String value);

}
