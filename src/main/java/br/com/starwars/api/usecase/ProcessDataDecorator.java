package br.com.starwars.api.usecase;

import br.com.starwars.api.domain.ProcessDataSW;

public interface ProcessDataDecorator {

    void execute(ProcessDataSW processDataSW);
}
