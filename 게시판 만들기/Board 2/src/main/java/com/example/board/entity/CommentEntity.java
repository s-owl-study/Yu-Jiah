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
@Table(name = "Comment")
@Entity
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;
    private String commentContent;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Timestamp commentWriteDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Timestamp commentWriteUpdate;


    private boolean commentDeleted;
    private String commentPassword;

    @ManyToOne
    @JoinColumn(name = "userNo")
    private UserEntity userEntity;


    @Builder
    public CommentEntity(Long commentNo, String commentContent, Timestamp commentWriteDate, Timestamp commentWriteUpdate, boolean commentDeleted, String commentPassword, UserEntity userEntity) {
        this.commentNo = commentNo;
        this.commentContent = commentContent;
        this.commentWriteDate = commentWriteDate;
        this.commentWriteUpdate = commentWriteUpdate;
        this.commentDeleted = commentDeleted;
        this.commentPassword = commentPassword;
        this.userEntity = userEntity;
    }
}
