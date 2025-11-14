package com.example.gameflix.repository;

import com.example.gameflix.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @JsonIgnore
    public Map<String, User> users = new HashMap();

    Optional<User> findByUsername(String username);

    public default boolean existsByUsername(String username){
        return users.containsKey(username);
    }
}
