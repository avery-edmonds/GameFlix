package com.example.gameflix.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_library")
public class UserLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer libraryId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private Date purchaseDate;

    // Getters and Setters
    public Integer getLibraryId() { return libraryId; }
    public void setLibraryId(Integer libraryId) { this.libraryId = libraryId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }

    public Date getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(Date purchaseDate) { this.purchaseDate = purchaseDate; }
}
