package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.exceptions.DataNotFoundException;
import br.com.starwars.api.exceptions.DatabaseException;
import br.com.starwars.api.external.repository.starwars.services.RepositoryService;
import br.com.starwars.api.interceptor.dto.ErrorDto;
import br.com.starwars.api.service.impl.GetFilmDataServiceImpl;
import br.com.starwars.api.usecase.UpdateFilmUseCase;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.orm.hibernate5.HibernateQueryException;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateFilmUseCaseImplTest {

    private RepositoryService repository;
    private UpdateFilmUseCase useCase;

    @BeforeEach
    void setUp() {
        repository = mock(RepositoryService.class);
        useCase = new UpdateFilmUseCaseImpl(repository);
    }

    @Test
    void musntThrowExceptionWhenCalled(){

        doNothing().when(repository).updateFilm(anyInt(), anyString());
        when(repository.existsId(anyInt())).thenReturn(Boolean.TRUE);

        assertDoesNotThrow(() -> useCase.execute(1, "teste filme"));

        verify(repository, times(1)).existsId(anyInt());
        verify(repository, times(1)).updateFilm(anyInt(), anyString());
    }

    @Test
    void shouldThrowDataNotFoundExceptionWhenEpisodeIdNotExists() {

        when(repository.existsId(anyInt())).thenReturn(Boolean.FALSE);

        assertThatThrownBy(() -> {
            useCase.execute(1000, "teste filme");
        }).isInstanceOf(DataNotFoundException.class)
                .extracting("erros", InstanceOfAssertFactories.list(ErrorDto.class))
                .extracting(ErrorDto::getTitle)
                .contains("Id inválido");

        verify(repository, times(1)).existsId(anyInt());
        verify(repository, times(0)).updateFilm(anyInt(), anyString());
    }
}
