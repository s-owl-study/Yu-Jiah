package com.example.board.dto;

import com.example.board.entity.AttachedFilesEntity;
import com.example.board.entity.CommentEntity;
import com.example.board.entity.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.xml.stream.XMLStreamConstants.NAMESPACE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class BoardListDto {
    private Long boardNo;
    private String boardTitle;
    private String boardContent;
    private Timestamp boardWriteDate;
    private Timestamp boardWriteUpdate;
    private boolean boardDeleted;
    private Long boardReadCount;
    private String boardPassword;
    private UserEntity userEntity;
    private AttachedFilesEntity attachedFilesEntity;
    private CommentEntity commentEntity;
//
//    public int insertBoard(BoardForm boardForm) throws Exception {
//        return sqlSession.insert(NAMESPACE + ".insertBoard", boardForm);
//    }
}

