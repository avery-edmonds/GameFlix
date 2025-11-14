package com.example.gameflix.model;

import jakarta.persistence.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "genre")
    private Genre genre;

    private Date releaseDate;
    private String developer;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String coverImage;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    // Getters and Setters
    public Integer getGameId() { return gameId; }
    public void setGameId(Integer gameId) { this.gameId = gameId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Genre getGenre() { return genre; }
    public void setGenre(Genre genre) { this.genre = genre; }

    public Date getReleaseDate() { return releaseDate; }
    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public String getDeveloper() { return developer; }
    public void setDeveloper(String developer) { this.developer = developer; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCoverImage() { return coverImage; }
    public void setCoverImage(String coverImage) { this.coverImage = coverImage; }
}
