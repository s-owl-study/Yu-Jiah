package com.todolist.todolist_jpa.dto;

import com.todolist.todolist_jpa.domain.entity.ListEntity;

public class ListDto {
    private Long List_id;
    private String List_completed;
    private String List_title;
    private String url;

    public ListDto(ListEntity listEntity) {
        this.List_id = listEntity.getList_id();
        this.List_completed = listEntity.getList_completed();
        this.List_title = listEntity.getList_title();
        this.url = "http://localhost:8090/" + this.List_id;

    }

}
