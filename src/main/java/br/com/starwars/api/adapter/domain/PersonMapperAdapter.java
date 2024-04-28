package br.com.starwars.api.adapter.domain;

import br.com.starwars.api.domain.Person;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, builder = @Builder(disableBuilder = true))
public interface PersonMapperAdapter {

    PersonMapperAdapter INSTANCE = Mappers.getMapper(PersonMapperAdapter.class);

    List<Person> map(List<String> value);

    @Mapping(target = "url", source = "value")
    Person map(String value);

}
