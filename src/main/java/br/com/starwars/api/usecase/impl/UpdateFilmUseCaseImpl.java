package br.com.starwars.api.usecase.impl;

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
        repositoryService.updateFilm(episodeId, description);
    }
}
