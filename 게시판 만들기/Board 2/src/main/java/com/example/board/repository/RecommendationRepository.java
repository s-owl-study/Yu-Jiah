package com.example.board.repository;

import com.example.board.entity.RecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<RecommendationEntity, Long> {
}
