package com.example.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Table(name = "Recommendation")
@Entity
public class RecommendationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationNo;

    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "boardNo")
    private BoardListEntity boardListEntity;

    @Builder
    public RecommendationEntity(Long recommendationNo, UserEntity userEntity, BoardListEntity boardListEntity) {
        this.recommendationNo = recommendationNo;
        this.userEntity = userEntity;
        this.boardListEntity = boardListEntity;
    }
}
