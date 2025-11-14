package com.example.gameflix.repository;


import com.example.gameflix.model.UserLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLibraryRepository extends JpaRepository<UserLibrary, Integer> {
    List<UserLibrary> findByUser_Id(long user_id);
    List<UserLibrary> findByGame_gameId(Integer gameId);
}
