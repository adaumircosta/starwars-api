package br.com.starwars.api.adapter.entities;

import br.com.starwars.api.domain.Person;
import br.com.starwars.api.external.repository.starwars.entities.PersonEntity;
import br.com.starwars.api.utils.StringUtils;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true), imports = {StringUtils.class})
public interface PersonEntityMapperAdapter {

    PersonEntityMapperAdapter INSTANCE = Mappers.getMapper(PersonEntityMapperAdapter.class);

    List<PersonEntity> convert(List<Person> list);

    @Mapping(target = "id", expression = "java(Integer.parseInt(StringUtils.extractValueFromURL(person.getUrl())))")
    @Mapping(target = "homeworld.id", expression = "java(Integer.parseInt(StringUtils.extractValueFromURL(planet.getUrl())))")
    PersonEntity convert(Person person);
}
