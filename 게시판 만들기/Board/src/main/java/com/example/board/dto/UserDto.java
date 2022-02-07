package com.example.board.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class UserDto {
    private Long userNo;
    private String userIp;
    private String userName;
}
