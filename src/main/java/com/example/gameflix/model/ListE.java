package com.example.gameflix.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "list")
public class ListE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String listName;

    private Date creationDate = new Date();

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    private List<ListGame> listGames = new ArrayList<>();

    // Getters and Setters
    public Integer getListId() { return listId; }
    public void setListId(Integer listId) { this.listId = listId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getListName() { return listName; }
    public void setListName(String listName) { this.listName = listName; }

    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }
}
