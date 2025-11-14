package com.example.gameflix.service;

import com.example.gameflix.model.ListE;
import com.example.gameflix.repository.ListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListService {

    private final ListRepository listRepository;

    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public List<ListE> getAllLists() {
        return listRepository.findAll();
    }

    public Optional<ListE> getListById(Integer id) {
        return listRepository.findById(id);
    }

    public List<ListE> getListsByUser(Integer userId) {
        return listRepository.findByUser_Id(userId);
    }

    public ListE createList(ListE list) {
        return listRepository.save(list);
    }

    public void deleteList(Integer id) {
        listRepository.deleteById(id);
    }
}
