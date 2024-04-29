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
@Table(name = "vehicle")
public class VehicleEntity {

    @Id
    @Column(name = "vehicle_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "cost_in_credits", length = 100)
    private String costInCredits;

    @Column(name = "length", length = 100)
    private String length;

    @Column(name = "max_atmospheric_speed")
    private Integer maxAtmosphericSpeed;

    @Column(name = "crew")
    private Integer crew;

    @Column(name = "passengers", length = 100)
    private String passengers;

    @Column(name = "cargo_capacity")
    private Long cargoCapacity;

    @Column(name = "consumables", length = 100)
    private String consumables;

    @Column(name = "vehicle_class", length = 100)
    private String vehicleClass;

    @Column(name = "url", nullable = false)
    private String url;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created", nullable = false)
    private Instant created;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "edited", nullable = false)
    private Instant edited;

}