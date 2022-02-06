package com.example.board.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Table(name = "AttachedFiles")
@Entity
public class AttachedFilesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileNo;

    private String fileName;

    private Long fileSize;

    private String fileUrl;

    @Builder
    public AttachedFilesEntity(Long fileNo, String fileName, Long fileSize, String fileUrl) {
        this.fileNo = fileNo;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileUrl = fileUrl;
    }
}
