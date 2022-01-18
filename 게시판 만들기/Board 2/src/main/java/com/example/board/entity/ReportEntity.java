package com.example.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Table(name = "Report")
@Entity
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportNo;

    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "boardNo")
    private BoardListEntity boardListEntity;

    @Builder
    public ReportEntity(Long reportNo, UserEntity userEntity, BoardListEntity boardListEntity) {
        this.reportNo = reportNo;
        this.userEntity = userEntity;
        this.boardListEntity = boardListEntity;
    }

}
