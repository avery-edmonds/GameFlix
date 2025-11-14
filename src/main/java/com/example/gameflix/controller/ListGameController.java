package com.example.gameflix.controller;

import com.example.gameflix.model.ListGame;
import com.example.gameflix.model.ListGameId;
import com.example.gameflix.service.ListGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list-games")
public class ListGameController {

    private final ListGameService listGameService;

    public ListGameController(ListGameService listGameService) {
        this.listGameService = listGameService;
    }

    @GetMapping("/list/{listId}")
    public List<ListGame> getGamesByList(@PathVariable Integer listId) {
        return listGameService.getByListId(listId);
    }

    @GetMapping("/game/{gameId}")
    public List<ListGame> getListsByGame(@PathVariable Integer gameId) {
        return listGameService.getByGameId(gameId);
    }

    @PostMapping
    public ListGame addGameToList(@RequestBody ListGame listGame) {
        return listGameService.addGameToList(listGame);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeGameFromList(@RequestBody ListGameId id) {
        listGameService.removeGameFromList(id);
        return ResponseEntity.noContent().build();
    }
}
