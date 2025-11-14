package com.example.gameflix.service;

import com.example.gameflix.model.Genre;
import com.example.gameflix.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(Integer id) {
        return genreRepository.findById(id);
    }

    public Genre getGenreByName(String name) {
        return genreRepository.findByName(name);
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }
}
