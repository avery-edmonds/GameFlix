package com.example.gameflix.repository;


import com.example.gameflix.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {


    List<Game> findByTitleContainingIgnoreCase(String title);
    List<Game> findByGenre_Name(String genreName);

}
