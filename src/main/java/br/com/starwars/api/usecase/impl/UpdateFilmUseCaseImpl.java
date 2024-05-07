package br.com.starwars.api.usecase.impl;

import br.com.starwars.api.exceptions.DataNotFoundException;
import br.com.starwars.api.external.repository.starwars.services.RepositoryService;
import br.com.starwars.api.usecase.UpdateFilmUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateFilmUseCaseImpl implements UpdateFilmUseCase {

    private final RepositoryService repositoryService;

    @Override
    public void execute(Integer episodeId, String description) {
        var exists = repositoryService.existsId(episodeId);
        if(!exists){
            throw new DataNotFoundException("Id inválido", "Houve um erro ao atualizar o film pois o id é inválido");
        }
        repositoryService.updateFilm(episodeId, description);
    }
}
