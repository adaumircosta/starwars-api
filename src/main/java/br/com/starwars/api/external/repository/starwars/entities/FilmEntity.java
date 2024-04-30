package br.com.starwars.api.external.repository.starwars.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "film")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "episode_id", nullable = false)
    private Integer episodeId;

    @Lob
    @Column(name = "opening_crawl")
    private String openingCrawl;

    @Column(name = "director", nullable = false, length = 100)
    private String director;

    @Column(name = "producer", nullable = false)
    private String producer;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "edited", nullable = false)
    private Instant edited;

    @Column(name = "version", nullable = false)
    private Integer version;

    @ManyToMany
    @JoinTable(
            name = "film_person",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<PersonEntity> characters;

    @ManyToMany
    @JoinTable(
            name = "film_planet",
            joinColumns = @JoinColumn(name = "planet_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<PlanetEntity> planets;

    @ManyToMany
    @JoinTable(
            name = "film_species",
            joinColumns = @JoinColumn(name = "species_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<SpeciesEntity> species;

    @ManyToMany
    @JoinTable(
            name = "film_vehicle",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<VehicleEntity> vehicles;

    @ManyToMany
    @JoinTable(
            name = "film_starship",
            joinColumns = @JoinColumn(name = "starship_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<StarshipEntity> starships;
}
