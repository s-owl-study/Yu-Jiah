package com.example.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@ToString
@Getter
@NoArgsConstructor
@Table(name = "BoardList")
@Entity
public class BoardListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;
    private String boardTitle;
    private String boardContent;

    private Timestamp boardWriteDate;
    private Timestamp boardWriteUpdate;

    private boolean boardDeleted;
    private Long boardReadCount;
    private String boardPassword;

    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "fileNo")
    private AttachedFilesEntity attachedFilesEntity;

    @ManyToOne
    @JoinColumn(name = "commentNo")
    private CommentEntity commentEntity;

    @Builder
    public BoardListEntity(Long boardNo, String boardTitle, String boardContent, Timestamp boardWriteDate, Timestamp boardWriteUpdate, boolean boardDeleted, Long boardReadCount, String boardPassword, UserEntity userEntity, AttachedFilesEntity attachedFilesEntity, CommentEntity commentEntity) {
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriteDate = boardWriteDate;
        this.boardWriteUpdate = boardWriteUpdate;
        this.boardDeleted = boardDeleted;
        this.boardReadCount = boardReadCount;
        this.boardPassword = boardPassword;
        this.userEntity = userEntity;
        this.attachedFilesEntity = attachedFilesEntity;
        this.commentEntity = commentEntity;
    }
}
