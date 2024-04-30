package br.com.starwars.api.external.repository.starwars.services.impl;

import br.com.starwars.api.exceptions.DatabaseException;
import br.com.starwars.api.external.repository.starwars.FilmRepository;
import br.com.starwars.api.external.repository.starwars.PersonRepository;
import br.com.starwars.api.external.repository.starwars.PlanetRepository;
import br.com.starwars.api.external.repository.starwars.SpeciesRepository;
import br.com.starwars.api.external.repository.starwars.StarshipRepository;
import br.com.starwars.api.external.repository.starwars.VehicleRepository;
import br.com.starwars.api.external.repository.starwars.entities.FilmEntity;
import br.com.starwars.api.external.repository.starwars.services.RepositoryService;
import br.com.starwars.api.external.repository.starwars.services.impl.builders.RepositoryServiceHelper;
import br.com.starwars.api.interceptor.dto.ErrorDto;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.orm.hibernate5.HibernateQueryException;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RepositoryServiceImplTest {

    private RepositoryService service;
    private FilmRepository filmRepository;
    private PersonRepository personRepository;
    private PlanetRepository planetRepository;
    private SpeciesRepository speciesRepository;
    private StarshipRepository starshipRepository;
    private VehicleRepository vehicleRepository;

    @BeforeEach
    void setUp() {
        filmRepository = mock(FilmRepository.class);
        personRepository = mock(PersonRepository.class);
        planetRepository = mock(PlanetRepository.class);
        speciesRepository = mock(SpeciesRepository.class);
        starshipRepository = mock(StarshipRepository.class);
        vehicleRepository = mock(VehicleRepository.class);
        service = new RepositoryServiceImpl(filmRepository, personRepository, planetRepository,
                speciesRepository, starshipRepository, vehicleRepository);
    }

    @Test
    void shouldGetSucessFullyListFilmFromDatabase() {

        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setId(123);
        filmEntity.setTitle("A New Hope");
        filmEntity.setEpisodeId(4);
        filmEntity.setDirector("George Lucas");
        filmEntity.setProducer("Gary Kurtz, Rick McCallum");
        filmEntity.setReleaseDate(LocalDate.parse("1977-05-25"));

        var expected = List.of(filmEntity);


        when(filmRepository.findAll()).thenReturn(expected);
        var result = service.getAllFilms();

        assertEquals(expected, result);
    }

    @Test
    void shouldGetSucessFullyDetailsFilmFromDatabase() {

        var expected = RepositoryServiceHelper.buildFilmEntity();


        when(filmRepository.findByEpisodeId(anyInt())).thenReturn(expected);
        var result = service.getFilmDetails(1);

        assertEquals(expected, result);
        verify(filmRepository, times(1)).findByEpisodeId(anyInt());
    }

    @Test
    void shouldUpdateSucessFullyFilmDescriptionOnDatabase() {

        when(filmRepository.updateDescription(anyInt(), anyString())).thenReturn(1);
        service.updateFilm(1, "teste");

        verify(filmRepository, times(1)).updateDescription(anyInt(), anyString());
    }

    @Test
    void shouldThrowDatabaseExceptionWhenUpdateIsNotSucessFully() {

        when(filmRepository.updateDescription(anyInt(), anyString())).thenThrow(HibernateQueryException.class);

        assertThatThrownBy(() -> {
            service.updateFilm(1, "teste");
        }).isInstanceOf(DatabaseException.class)
                .extracting("erros", InstanceOfAssertFactories.list(ErrorDto.class))
                .extracting(ErrorDto::getTitle)
                .contains("Database Error");

        verify(filmRepository, times(1)).updateDescription(anyInt(), anyString());
    }

    @Test
    void shouldInsertSucessFullyFilmsOnOnDatabase() {

        var expect = List.of(RepositoryServiceHelper.buildFilmEntity());

        when(filmRepository.saveAllAndFlush(anyCollection())).thenReturn(expect);
        service.insertAllFilms(expect);

        verify(filmRepository, times(1)).saveAllAndFlush(anyCollection());
    }

    @Test
    void shouldInsertSucessFullyPeopleOnDatabase() {

        var expect = List.of(RepositoryServiceHelper.buildPersonEntity());

        when(personRepository.saveAllAndFlush(anyCollection())).thenReturn(expect);
        service.insertAllPeople(expect);

        verify(personRepository, times(1)).saveAllAndFlush(anyCollection());
    }

    @Test
    void shouldInsertSucessFullyPlanetOnDatabase() {

        var expect = List.of(RepositoryServiceHelper.buildPlanetEntity());

        when(planetRepository.saveAllAndFlush(anyCollection())).thenReturn(expect);
        service.insertAllPlanets(expect);

        verify(planetRepository, times(1)).saveAllAndFlush(anyCollection());
    }

    @Test
    void shouldInsertSucessFullySpeciesOnDatabase() {

        var expect = List.of(RepositoryServiceHelper.buildSpeciesEntity());

        when(speciesRepository.saveAllAndFlush(anyCollection())).thenReturn(expect);
        service.insertAllSpecies(expect);

        verify(speciesRepository, times(1)).saveAllAndFlush(anyCollection());
    }

    @Test
    void shouldInsertSucessFullyStarshipOnDatabase() {

        var expect = List.of(RepositoryServiceHelper.buildStarshipEntity());

        when(starshipRepository.saveAllAndFlush(anyCollection())).thenReturn(expect);
        service.insertAllStarships(expect);

        verify(starshipRepository, times(1)).saveAllAndFlush(anyCollection());
    }

    @Test
    void shouldInsertSucessFullyVehicleOnDatabase() {

        var expect = List.of(RepositoryServiceHelper.buildVechileEntity());

        when(vehicleRepository.saveAllAndFlush(anyCollection())).thenReturn(expect);
        service.insertAllVehicles(expect);

        verify(vehicleRepository, times(1)).saveAllAndFlush(anyCollection());
    }


}
