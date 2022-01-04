package com.todolist.todolist_jpa.service;

import com.todolist.todolist_jpa.domain.entity.ListEntity;
import com.todolist.todolist_jpa.dto.ListDto;
import com.todolist.todolist_jpa.repository.ListRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ListServiceImpl implements ListService {


    @Autowired
    ListRepository listRepository;

    @Override
    public ListEntity add(ListDto listDto) {
        ListEntity listEntity = ListEntity.builder()
                .listId(listDto.getListId())
                .listTitle(listDto.getListTitle())
                .listCompleted(listDto.getListCompleted())
                .build();
        return this.listRepository.save(listEntity);
    }

    @Override
    public ListEntity searchById(Long listId) {
        return this.listRepository.findById(listId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<ListEntity> searchAll() {
        return this.listRepository.findAll();
    }

    @Override
    public ListEntity updateById(Long listId, ListDto listDto) {
        ListEntity listEntity = this.searchById(listId);

        if (listDto.getListId() != null) {
            listEntity.setListId(listDto.getListId());
        }

        if (listDto.getListTitle() != null) {
            listEntity.setListTitle(listDto.getListTitle());
        }

        if (listDto.getListCompleted() != null) {
            listEntity.setListCompleted(listDto.getListCompleted());
        }

        return this.listRepository.save(listEntity);
    }

    @Override
    public void deleteById(Long listId) {
        this.listRepository.deleteById(listId);
    }

    @Override
    public void deleteAll() {
        this.listRepository.deleteAll();

    }
}
