package com.todolist.todolist_jpa.controller;

import com.todolist.todolist_jpa.domain.entity.ListEntity;
import com.todolist.todolist_jpa.dto.ListDto;
import com.todolist.todolist_jpa.service.ListServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class ListController {

    @Autowired
    ListServiceImpl listService;

    @PostMapping
    public ResponseEntity<ListEntity> create(@RequestBody ListDto listDto) {
        if (ObjectUtils.isEmpty(listDto.getListId())) {
            return ResponseEntity.badRequest().build();
        }

        if (ObjectUtils.isEmpty(listDto.getListTitle())) {
            listDto.setListTitle("");
        }

        if (ObjectUtils.isEmpty(listDto.getListCompleted())) {
            listDto.setListCompleted("");
        }

        ListEntity result = this.listService.add(listDto);

        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<ListEntity> readOne(@PathVariable Long listId) {
        ListEntity result = this.listService.searchById(listId);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<ListDto>> readAll() {
        List<ListEntity> resultList = this.listService.searchAll();
        List<ListDto> response = resultList
                .stream()
                .map( result -> new ListDto(result) )
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<ListDto> update(@PathVariable Long listId, @RequestBody ListDto listDto) {
        ListEntity result = this.listService.updateById(listId, listDto);
        ListDto response = new ListDto(result);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> removeOne(@PathVariable Long listId) {
        this.listService.deleteById(listId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> removeAll() {
        this.listService.deleteAll();
        return ResponseEntity.ok().build();
    }
}