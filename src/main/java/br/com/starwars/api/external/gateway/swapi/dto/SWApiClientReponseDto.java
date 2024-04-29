package br.com.starwars.api.external.gateway.swapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class SWApiClientReponseDto<T> {

    private Integer count;
    private String next;
    private String previous;
    public abstract List<T> getResults();


}
