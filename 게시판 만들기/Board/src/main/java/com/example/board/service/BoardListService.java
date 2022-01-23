package com.example.board.service;

import com.example.board.dto.BoardListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardListService {

//    @Autowired
//    BoardListDto boardListDto;
//
//
//    public BoardListDto insertBoard(BoardForm boardForm) throws Exception {
//
////        BoardListDto boardDto = new BoardListDto();
//
//        int insertCnt = 0;
//
////        int boardReRef = boardDao.getBoardReRef(boardForm);
////        boardForm.setBoard_re_ref(boardReRef);
//
//        insertCnt = boardListDto.insertBoard(boardForm);
//
//        List<BoardFileForm> boardFileList = getBoardFileInfo(boardForm);
//        for (BoardFileForm boardFileForm : boardFileList) {
//            boardListDto.insertBoardFile(boardFileForm);
//        }
//
//        if (insertCnt > 0) {
//            boardListDto.setResult("SUCCESS");
//        } else {
//            boardListDto.setResult("FAIL");
//        }
//
//        return boardDto;
//    }

}
