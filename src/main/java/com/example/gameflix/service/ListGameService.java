package com.example.gameflix.service;

import com.example.gameflix.model.ListGame;
import com.example.gameflix.model.ListGameId;
import com.example.gameflix.repository.ListGameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListGameService {

    private final ListGameRepository listGameRepository;

    public ListGameService(ListGameRepository listGameRepository) {
        this.listGameRepository = listGameRepository;
    }

    public List<ListGame> getByListId(Integer listId) {
        return listGameRepository.findByListListId(listId);
    }

    public List<ListGame> getByGameId(Integer gameId) {
        return listGameRepository.findByGameGameId(gameId);
    }

    public ListGame addGameToList(ListGame listGame) {
        return listGameRepository.save(listGame);
    }

    public void removeGameFromList(ListGameId id) {
        listGameRepository.deleteById(id);
    }
}
