package com.todolist.todolist_jpa.dto;

import com.todolist.todolist_jpa.domain.entity.ListEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListDto {
    private Long listId;
    private String listCompleted;
    private String listTitle;
    private String url;

    public ListDto(ListEntity listEntity) {
        this.listId = listEntity.getListId();
        this.listCompleted = listEntity.getListCompleted();
        this.listTitle = listEntity.getListTitle();
        this.url = "http://localhost:9090/" + this.listId;

    }
}
