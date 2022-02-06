package com.example.board.repository;

import com.example.board.entity.AttachedFilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachedFilesRepository extends JpaRepository<AttachedFilesEntity, Long> {
}
