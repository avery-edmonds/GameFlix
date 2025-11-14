package com.example.gameflix.controller;

import com.example.gameflix.model.UserLibrary;
import com.example.gameflix.service.UserLibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class UserLibraryController {

    private final UserLibraryService userLibraryService;

    public UserLibraryController(UserLibraryService userLibraryService) {
        this.userLibraryService = userLibraryService;
    }

    @GetMapping
    public List<UserLibrary> getAllLibraries() {
        return userLibraryService.getAllLibraries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserLibrary> getLibraryById(@PathVariable Integer id) {
        return userLibraryService.getLibraryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<UserLibrary> getLibrariesByUser(@PathVariable Integer userId) {
        return userLibraryService.getLibrariesByUser(userId);
    }

    @PostMapping
    public UserLibrary addToLibrary(@RequestBody UserLibrary library) {
        return userLibraryService.addToLibrary(library);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibraryEntry(@PathVariable Integer id) {
        userLibraryService.deleteLibraryEntry(id);
        return ResponseEntity.noContent().build();
    }
}
