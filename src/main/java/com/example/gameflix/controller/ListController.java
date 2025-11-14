package com.example.gameflix.controller;

import com.example.gameflix.model.ListE;
import com.example.gameflix.service.ListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lists")
public class ListController {

    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @GetMapping
    public List<ListE> getAllLists() {
        return listService.getAllLists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListE> getListById(@PathVariable Integer id) {
        return listService.getListById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<ListE> getListsByUser(@PathVariable Integer userId) {
        return listService.getListsByUser(userId);
    }

    @PostMapping
    public ListE createList(@RequestBody ListE list) {
        return listService.createList(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable Integer id) {
        listService.deleteList(id);
        return ResponseEntity.noContent().build();
    }
}
