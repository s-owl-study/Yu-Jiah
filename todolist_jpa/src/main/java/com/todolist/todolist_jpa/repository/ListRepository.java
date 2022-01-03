package com.todolist.todolist_jpa.repository;

import com.todolist.todolist_jpa.domain.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListEntity, Long> {}