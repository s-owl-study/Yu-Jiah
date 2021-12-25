package com.todolist.todolist_jpa.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long List_id; //투두 리스트 순서

    @Column(nullable = false)
    private String List_completed; //완료 여부

    @Column(nullable = false)
    private String List_title; //투두 리스트 내용

}
