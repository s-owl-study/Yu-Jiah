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
                .List_id(listDto.getList_id())
                .List_title(listDto.getList_title())
                .List_completed(listDto.getList_completed())
                .build();
        return this.listRepository.save(listEntity);
    }

    @Override
    public ListEntity searchById(Long List_id) {
        return this.listRepository.findById(List_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<ListEntity> searchAll() {
        return this.listRepository.findAll();
    }

    @Override
    public ListEntity updateById(Long List_id, ListDto listDto) {
        ListEntity listEntity = this.searchById(List_id);

        if (listDto.getList_id() != null) {
            listEntity.setList_id(listDto.getList_id());
        }

        if (listDto.getlist_title() != null) {
            listEntity.setList_title(listDto.getList_title());
        }

        if (listDto.getList_completed() != null) {
            listEntity.setList_completed(listDto.getList_completed());
        }

        return this.listRepository.save(listEntity);
    }

    @Override
    public void deleteById(Long List_id) {
        this.listRepository.deleteById(List_id);
    }

    @Override
    public void deleteAll() {
        this.listRepository.deleteAll();

    }
}
