package br.com.starwars.api.external.repository.starwars.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "starship")
public class StarshipEntity {

    @Id
    @Column(name = "starship_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "cost_in_credits", length = 100)
    private String costInCredits;

    @Column(name = "length", length = 50)
    private String length;

    @Column(name = "max_atmospheric_speed")
    private String maxAtmosphericSpeed;

    @Column(name = "crew", length = 50)
    private String crew;

    @Column(name = "passengers", length = 50)
    private String passengers;

    @Column(name = "cargo_capacity")
    private String cargoCapacity;

    @Column(name = "consumables", length = 100)
    private String consumables;

    @Column(name = "hyperdrive_rating")
    private String hyperdriveRating;

    @Column(name = "MGLT")
    private String mglt;

    @Column(name = "starship_class", length = 100)
    private String starshipClass;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "created", nullable = false)
    private Instant created;

    @Column(name = "edited", nullable = false)
    private Instant edited;

    @ManyToMany(mappedBy = "starships", fetch = FetchType.LAZY)
    private List<FilmEntity> films;
}
