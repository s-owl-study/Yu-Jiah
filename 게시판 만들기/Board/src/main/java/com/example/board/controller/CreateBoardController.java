package com.example.board.controller;

import com.example.board.dto.BoardListDto;
import com.example.board.service.BoardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Controller
//public class CreateBoardController {
//    @Autowired
//    BoardListService boardListService;
//
//
//    @RequestMapping(value = "/insertBoard") //게시글 등록
//    @ResponseBody
//    public BoardListDto insertBoard(HttpServletRequest request, HttpServletResponse response, BoardForm boardForm) throws Exception {
//
//        BoardListDto boardListDto = boardListService.insertBoard(boardForm);
//
//        return boardListDto;
//    }
//}
