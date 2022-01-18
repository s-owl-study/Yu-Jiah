package com.example.board.dto;

import com.example.board.entity.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class CommentDto {
    private Long commentNo;
    private String commentContent;
    private Timestamp commentWriteDate;
    private Timestamp commentWriteUpdate;
    private boolean commentDeleted;
    private String commentPassword;
    private UserEntity userEntity;
}
