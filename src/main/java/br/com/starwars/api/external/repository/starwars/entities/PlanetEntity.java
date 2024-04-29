package br.com.starwars.api.external.repository.starwars.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "planet")
public class PlanetEntity {

    @Id
    @Column(name = "planet_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "rotation_period", length = 100)
    private String rotationPeriod;

    @Column(name = "orbital_period")
    private String orbitalPeriod;

    @Column(name = "diameter", length = 100)
    private String diameter;

    @Column(name = "climate", length = 100)
    private String climate;

    @Column(name = "gravity", length = 100)
    private String gravity;

    @Column(name = "terrain", length = 100)
    private String terrain;

    @Column(name = "surface_water", length = 100)
    private String surfaceWater;

    @Column(name = "population", length = 100)
    private String population;

    @Column(name = "url", nullable = false)
    private String url;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created", nullable = false)
    private Instant created;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "edited", nullable = false)
    private Instant edited;

}