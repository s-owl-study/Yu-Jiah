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
    public ResponseEntity<ListDto> create(@RequestBody ListDto listDto) {
        if (ObjectUtils.isEmpty(listDto.getList_id())) {
            return ResponseEntity.badRequest().build();
        }

        if (ObjectUtils.isEmpty(listDto.getList_title())) {
            listDto.setList_title("");
        }

        if (ObjectUtils.isEmpty(listDto.getList_Completed())) {
            listDto.setList_Completed("");
        }

        ListEntity result = this.listService.add(listDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ListDto> readOne(@PathVariable Long List_id) {
        ListEntity result = this.listService.searchById(List_id);
        return ResponseEntity.ok(response);
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
    public ResponseEntity<ListDto> update(@PathVariable Long List_id, @RequestBody ListDto listDto) {
        ListEntity result = this.listService.updateById(List_id, listDto);
        ListDto response = new ListDto(result);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> removeOne(@PathVariable Long List_id) {
        this.listService.deleteById(List_id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> removeAll() {
        this.listService.deleteAll();
        return ResponseEntity.ok().build();
    }
}