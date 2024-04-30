package br.com.starwars.api.adapter.resource;

import br.com.starwars.api.domain.Film;
import br.com.starwars.api.resource.dto.FilmDetailResponseDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface FilmDetailResponseDtoMapperAdapter {

    FilmDetailResponseDtoMapperAdapter INSTANCE = Mappers.getMapper(FilmDetailResponseDtoMapperAdapter.class);

    List<FilmDetailResponseDto> convert(List<Film> films);

    FilmDetailResponseDto convert(Film film);
}
