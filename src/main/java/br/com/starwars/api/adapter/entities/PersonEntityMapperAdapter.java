package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Person;
import br.com.starwars.api.external.repository.starwars.entities.PersonEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface PersonEntityMapperAdapter {

    PersonEntityMapperAdapter INSTANCE = Mappers.getMapper(PersonEntityMapperAdapter.class);

    List<PersonEntity> convert(List<Person> films);
}
