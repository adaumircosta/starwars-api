package br.com.starwars.api.adapter.resource;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.resource.dto.FilmResponseDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface FilmResponseDtoMapperAdapter {

    FilmResponseDtoMapperAdapter INSTANCE = Mappers.getMapper(FilmResponseDtoMapperAdapter.class);

    List<FilmResponseDto> convert(List<Film> films);

    FilmResponseDto convert(Film film);
}
