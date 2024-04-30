package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.external.repository.starwars.services.RepositoryService;
import br.com.starwars.api.service.impl.GetFilmDataServiceImpl;
import br.com.starwars.api.usecase.UpdateFilmUseCase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        assertDoesNotThrow(() -> useCase.execute(1, "teste filme"));
        verify(repository, times(1)).updateFilm(anyInt(), anyString());
    }
}
