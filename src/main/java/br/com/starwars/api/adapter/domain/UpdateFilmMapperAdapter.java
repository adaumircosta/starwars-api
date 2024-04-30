package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.UpdateFilm;
import br.com.starwars.api.resource.dto.UpdateFilmRequestDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface UpdateFilmMapperAdapter {

    UpdateFilmMapperAdapter INSTANCE = Mappers.getMapper(UpdateFilmMapperAdapter.class);

    UpdateFilm convert(UpdateFilmRequestDto updateFilmRequestDto);
}
