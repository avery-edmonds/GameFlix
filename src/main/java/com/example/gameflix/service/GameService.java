package com.example.gameflix.service;

import com.example.gameflix.model.Game;
import com.example.gameflix.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Integer id) {
        return gameRepository.findById(id);
    }

    public List<Game> searchByTitle(String title) {
        return gameRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Game> getGamesByGenre(String genreName) {
        return gameRepository.findByGenre_Name(genreName);
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Game updateGame(Integer id, Game updatedGame) {
        return gameRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(updatedGame.getTitle());
                    existing.setGenre(updatedGame.getGenre());
                    existing.setReleaseDate(updatedGame.getReleaseDate());
                    existing.setDeveloper(updatedGame.getDeveloper());
                    existing.setDescription(updatedGame.getDescription());
                    existing.setCoverImage(updatedGame.getCoverImage());
                    return gameRepository.save(existing);
                }).orElseThrow(() -> new RuntimeException("Game not found"));
    }

    public void deleteGame(Integer id) {
        gameRepository.deleteById(id);
    }
}
