package com.example.gameflix.model;

import java.io.Serializable;
import java.util.Objects;

public class ListGameId implements Serializable {
    private Integer list;
    private Integer game;

    public ListGameId() {}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListGameId that = (ListGameId) o;
        return Objects.equals(list, that.list) &&
                Objects.equals(game, that.game);
    }


    @Override
    public int hashCode() {
        return Objects.hash(list, game);
    }
}
