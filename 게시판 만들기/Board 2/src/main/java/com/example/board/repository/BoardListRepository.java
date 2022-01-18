package com.example.board.repository;

import com.example.board.entity.BoardListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardListRepository extends JpaRepository<BoardListEntity, Long> {
}
