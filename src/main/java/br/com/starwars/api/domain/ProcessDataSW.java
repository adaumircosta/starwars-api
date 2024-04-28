package br.com.starwars.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProcessDataSW {

    private List<Film> film;
    private List<Planet> planet;
    private List<Person> person;
    private List<Species> species;
    private List<Vehicle> vehicle;
    private List<Starship> starship;
}
