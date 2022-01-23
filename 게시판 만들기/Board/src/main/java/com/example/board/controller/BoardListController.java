package com.example.board.controller;

import com.example.board.dto.BoardListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/board")
public class BoardListController {
//
//    @Autowired
//    private BoardService boardService;

    //게시판 리스트
    @RequestMapping(value = "/boardList") //게시글 목록
    public String boardList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "mainpage";
    }

    @RequestMapping("/createBoard") //게시글 등록 페이지로 이동
    public String createBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "createpage";
    }

//    @RequestMapping(value = "/insertBoard") //게시글 등록
//    @ResponseBody
//    public BoardListDto insertBoard(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {
//
//        BoardListDto boardDto = boardListService.insertBoard(boardForm);
//
//        return BoardListDto;
//    }

    @RequestMapping("/boardDetail/{boardNo}")
    public String boardDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable String boardNo) throws Exception {

        return "readpage";
    }

    @RequestMapping("/boardUpdate?boardNo={boardNo}")
    public String updateBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "updatepage";
    }
    @RequestMapping("/identificationForDelete")
    public String identifyForUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "identificationfordelete";
    }

    @RequestMapping("/identificationForUpdate")
    public String identifyForDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "identificationforupdate";
    }


//    @PostMapping(value = "/board/createboard")
//    public String boardList(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//        return "createpage";
//    }


//    @RequestMapping(value = "/getBoardList")
//    @ResponseBody
//    public ResultUtil getBoardList(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {
//
//        ResultUtil resultUtils = boardService.getBoardList(boardForm);
//
//        return resultUtils;
//    }
}