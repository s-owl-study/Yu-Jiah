package com.example.board.dto;

import com.example.board.entity.BoardListEntity;
import com.example.board.entity.UserEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class ReportDto {
    private Long reportNo;
    private UserEntity userEntity;
    private BoardListEntity boardListEntity;
}
