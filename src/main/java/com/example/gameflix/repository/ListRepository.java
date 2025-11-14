package com.example.gameflix.repository;

import com.example.gameflix.model.ListE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListRepository extends JpaRepository<ListE, Integer> {
    List<ListE> findByUser_Id(long user_id);
}
