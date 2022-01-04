package com.todolist.todolist_jpa.domain.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "listEntity")
@Getter
@Setter
public class ListEntity { //list만 쓰면 위험함

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId; //투두 리스트 순서

    @Column(nullable = false)
    private boolean listCompleted; //완료 여부

    @Column(nullable = false)
    private String listTitle; //투두 리스트 내용

}
