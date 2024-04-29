package br.com.starwars.api.external.repository.starwars.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "species")
public class SpeciesEntity {

    @Id
    @Column(name = "species_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "classification", length = 50)
    private String classification;

    @Column(name = "designation", length = 50)
    private String designation;

    @Column(name = "average_height")
    private String averageHeight;

    @Column(name = "skin_colors")
    private String skinColors;

    @Column(name = "hair_colors")
    private String hairColors;

    @Column(name = "eye_colors")
    private String eyeColors;

    @Column(name = "average_lifespan")
    private String averageLifespan;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "homeworld")
    private PlanetEntity homeworld;

    @Column(name = "language", length = 100)
    private String language;

    @Column(name = "url", nullable = false)
    private String url;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created", nullable = false)
    private Instant created;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "edited", nullable = false)
    private Instant edited;

}