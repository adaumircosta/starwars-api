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
@Table(name = "person")
public class PersonEntity {

    @Id
    @Column(name = "person_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "height", length = 50)
    private String height;

    @Column(name = "mass", length = 50)
    private String mass;

    @Column(name = "hair_color", length = 50)
    private String hairColor;

    @Column(name = "skin_color", length = 50)
    private String skinColor;

    @Column(name = "eye_color", length = 50)
    private String eyeColor;

    @Column(name = "birth_year", length = 10)
    private String birthYear;

    @Column(name = "gender", length = 10)
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "homeworld")
    private PlanetEntity homeworld;

    @Column(name = "url", nullable = false)
    private String url;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created", nullable = false)
    private Instant created;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "edited", nullable = false)
    private Instant edited;

}