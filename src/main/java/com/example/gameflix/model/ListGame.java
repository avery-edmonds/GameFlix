package com.example.gameflix.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(ListGameId.class)
@Table(name = "list_game")
public class ListGame {

    @Id
    @ManyToOne
    @JoinColumn(name = "list_id")
    private ListE list;

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private LocalDateTime added = LocalDateTime.now();



    public ListE getList() {
        return list;
    }

    public void setList(ListE list) {
        this.list = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public void setAdded(LocalDateTime added) {
        this.added = added;
    }
}
