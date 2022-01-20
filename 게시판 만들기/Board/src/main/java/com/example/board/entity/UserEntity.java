package com.example.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor
@Table(name = "User")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToMany
    @JoinColumn(name = "userNo")
    private UserEntity userEntity;

    private String userName;

    private String userIp;

    @Builder
    public UserEntity(UserEntity userEntity, String userIp, String userName) {
        this.userEntity = userEntity;
        this.userIp = userIp;
        this.userName = userName;
    }
}
