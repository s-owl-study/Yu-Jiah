package com.todolist.todolist_jpa.service;

import com.todolist.todolist_jpa.domain.entity.ListEntity;
import com.todolist.todolist_jpa.dto.ListDto;
import com.todolist.todolist_jpa.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ListServiceImpl implements ListService{


    @Autowired
    ListRepository listRepository;

    @Override
    public ListEntity add(ListDto listDto) {
        ListEntity listEntity = ListEntity.builder()
                .listId(listDto.getListId())
                .listTitle(listDto.getListTitle())
                .listCompleted(listDto.isListCompleted())
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
    public List<ListEntity> updateById(Long listId, ListDto listDto) {
        ListEntity todo = ListEntity.builder()
                .listId(listId)
                .listTitle(listDto.getListTitle())
                .listCompleted(listDto.isListCompleted())
                .build();
        this.listRepository.save(todo);
        return this.listRepository.findAll();


    }

    @Override
    @Transactional
    public List<ListEntity> deleteById(Long listId){
        this.listRepository.deleteById(listId);
        return listRepository.findAll();
    }

    @Override
    public void deleteAll() {
        this.listRepository.deleteAll();
    }

}

