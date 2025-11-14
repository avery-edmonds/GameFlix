package com.example.gameflix.repository;

import com.example.gameflix.model.ListGame;
import com.example.gameflix.model.ListGameId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListGameRepository extends JpaRepository<ListGame, ListGameId> {
    List<ListGame> findByListListId(Integer listId);

    List<ListGame> findByGameGameId(Integer gameId);
}
