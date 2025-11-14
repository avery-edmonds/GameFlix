package com.example.gameflix.service;

import com.example.gameflix.model.UserLibrary;
import com.example.gameflix.repository.UserLibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserLibraryService {

    private final UserLibraryRepository userLibraryRepository;

    public UserLibraryService(UserLibraryRepository userLibraryRepository) {
        this.userLibraryRepository = userLibraryRepository;
    }

    public List<UserLibrary> getAllLibraries() {
        return userLibraryRepository.findAll();
    }

    public Optional<UserLibrary> getLibraryById(Integer id) {
        return userLibraryRepository.findById(id);
    }

    public List<UserLibrary> getLibrariesByUser(Integer userId) {
        return userLibraryRepository.findByUser_Id(userId);
    }

    public UserLibrary addToLibrary(UserLibrary library) {
        return userLibraryRepository.save(library);
    }

    public void deleteLibraryEntry(Integer id) {
        userLibraryRepository.deleteById(id);
    }
}
