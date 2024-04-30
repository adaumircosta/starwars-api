package br.com.starwars.api.usecase;

public interface UpdateFilmUseCase {

    void execute(Integer episodeId, String description);
}
