package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.domain.ProcessDataSW;
import br.com.starwars.api.usecase.ProcessDataDecorator;
import br.com.starwars.api.usecase.ProcessSWDataUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProcessSWDataUseCaseImpl implements ProcessSWDataUseCase {

    private final List<ProcessDataDecorator> decorator;


    @Override
    @EventListener(ContextRefreshedEvent.class)
    public void execute(){
        ProcessDataSW processDataSW = new ProcessDataSW();
        decorator.forEach(processDataDecorator -> processDataDecorator.execute(processDataSW));
    }
}
