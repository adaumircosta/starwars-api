package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.usecase.ProcessDataDecorator;
import br.com.starwars.api.usecase.ProcessSWDataUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProcessSWDataUseCaseImplTest {

    private ProcessDataDecorator decorator;
    private ProcessSWDataUseCase useCase;

    @BeforeEach
    void setUp() {
        decorator = mock(ProcessDataDecorator.class);
        useCase = new ProcessSWDataUseCaseImpl(Collections.singletonList(decorator));
    }

    @Test
    void mustBeExecuteCallAndDoesntThrowException(){

        assertDoesNotThrow(() -> useCase.execute());
        verify(decorator, times(1)).execute(any());
    }
}
