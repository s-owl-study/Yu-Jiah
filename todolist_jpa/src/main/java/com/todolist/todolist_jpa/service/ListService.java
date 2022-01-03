package com.todolist.todolist_jpa.service;

import com.todolist.todolist_jpa.domain.entity.ListEntity;
import com.todolist.todolist_jpa.dto.ListDto;

import java.util.List;

public interface ListService {

    ListEntity add(ListDto listDto); //리스트 추가
    ListEntity searchById(Long listId); //아이디로 리스트 찾기
    List<ListEntity> searchAll(); //전체 검색
    ListEntity updateById(Long listId, ListDto listDto); //아이디로 업데이트하기
    void deleteById(Long listId); //아이디로 삭제
    void deleteAll(); //전체 삭제
}
