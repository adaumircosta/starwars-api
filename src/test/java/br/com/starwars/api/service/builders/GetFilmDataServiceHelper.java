package br.com.starwars.api.service.builders;

import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import br.com.starwars.api.external.repository.starwars.entities.PersonEntity;
import br.com.starwars.api.external.repository.starwars.entities.PlanetEntity;
import br.com.starwars.api.external.repository.starwars.entities.SpeciesEntity;
import br.com.starwars.api.external.repository.starwars.entities.StarshipEntity;
import br.com.starwars.api.external.repository.starwars.entities.VehicleEntity;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class GetFilmDataServiceHelper {

    public FilmEntity buildFilmEntity() {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setId(123);
        filmEntity.setTitle("A New Hope");
        filmEntity.setEpisodeId(4);
        filmEntity.setDirector("George Lucas");
        filmEntity.setProducer("Gary Kurtz, Rick McCallum");
        filmEntity.setReleaseDate(LocalDate.parse("1977-05-25"));

        return filmEntity;
    }

    public PersonEntity buildPersonEntity() {

        PersonEntity personEntity = new PersonEntity();
        personEntity.setName("Luke Skywalker");
        personEntity.setHeight("172");
        personEntity.setMass("77");
        personEntity.setHairColor("blond");
        personEntity.setSkinColor("fair");
        personEntity.setGender("male");

        return personEntity;
    }

    public PlanetEntity buildPlanetEntity() {

        PlanetEntity planetEntity = new PlanetEntity();
        planetEntity.setName("Luke Skywalker");
        planetEntity.setRotationPeriod("23");
        planetEntity.setOrbitalPeriod("304");
        planetEntity.setDiameter("10465");
        planetEntity.setClimate("arid");
        planetEntity.setPopulation("200000");

        return planetEntity;
    }

    public SpeciesEntity buildSpeciesEntity() {

        SpeciesEntity speciesEntity = new SpeciesEntity();
        speciesEntity.setName("Human");
        speciesEntity.setClassification("mammal");
        speciesEntity.setDesignation("sentient");
        speciesEntity.setAverageHeight("180");
        speciesEntity.setEyeColors("brown, blue, green, hazel, grey, amber");
        speciesEntity.setLanguage("Galactic Basic");

        return speciesEntity;
    }

    public StarshipEntity buildStarshipEntity() {

        StarshipEntity starshipEntity = new StarshipEntity();
        starshipEntity.setName("CR90 corvette");
        starshipEntity.setModel("CR90 corvette");
        starshipEntity.setManufacturer("Corellian Engineering Corporation");
        starshipEntity.setCostInCredits("3500000");
        starshipEntity.setMglt("60");
        starshipEntity.setStarshipClass("corvette");

        return starshipEntity;
    }

    public VehicleEntity buildVechileEntity() {

        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setName("Sand Crawler");
        vehicleEntity.setModel("Digger Crawler");
        vehicleEntity.setManufacturer("Corellia Mining Corporation");
        vehicleEntity.setLength("36.8");
        vehicleEntity.setMaxAtmosphericSpeed("30");
        vehicleEntity.setCargoCapacity("50000");

        return vehicleEntity;
    }

}
