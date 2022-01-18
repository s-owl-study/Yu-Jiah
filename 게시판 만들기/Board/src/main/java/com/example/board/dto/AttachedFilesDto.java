package com.example.board.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class AttachedFilesDto {
    private Long fileNo;
    private String fileName;
    private Long fileSize;
    private String fileUrl;

}
