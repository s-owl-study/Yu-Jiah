package com.todolist.todolist_jpa.dto;

import com.todolist.todolist_jpa.domain.entity.ListEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ListDto {
    private Long listId;
    private boolean listCompleted;
    private String listTitle;

    public ListDto(ListEntity listEntity) {
        this.listId = listEntity.getListId();
        this.listCompleted = listEntity.isListCompleted();
        this.listTitle = listEntity.getListTitle();
    }
}
