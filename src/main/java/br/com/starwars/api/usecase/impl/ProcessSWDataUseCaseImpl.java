package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.domain.ProcessDataSW;
import br.com.starwars.api.usecase.ProcessDataDecorator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProcessSWDataUseCaseImpl {

    private final List<ProcessDataDecorator> decorator;

    @EventListener(ContextRefreshedEvent.class)
    public void getDataSW(){
        System.out.println("Iniciando processamento");
        ProcessDataSW processDataSW = new ProcessDataSW();
        decorator.forEach(processDataDecorator -> processDataDecorator.execute(processDataSW));
        System.out.println("Finalizando processamento");
    }
}
