package com.example.board.service;

import com.example.board.dto.BoardListDto;

import java.util.List;

public class BoardListService {


    //게시글 저장
   public void createBoard(BoardListDto boardListDto){

   }

   //게시글 수정
   public void updateBoard(Long boardNo){

   }

   //게시글 삭제
    public void deleteBoard(Long boardNo){

    }

    //전체 검색
   public List<BoardListDto> searchAll(){

   }

   //유저이름으로 검색
    public List<BoardListDto> searchByUserName(String userName){

    }

    //내용, 제목으로 검색
    public List<BoardListDto> searchByBoardContent(String boardContent, String boardTitle) {
    }

}
