package com.example.board.board.controller;

import com.example.board.board.dto.request.BoardCreateRequest;
import com.example.board.board.dto.request.BoardUpdateRequest;
import com.example.board.board.service.BoardService;
import com.example.board.config.BaseException;
import com.example.board.util.ApiResult;
import com.example.board.util.Apiutils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @PostMapping(value = "/boards")
    public ApiResult<?> boardCreate(@RequestBody BoardCreateRequest boardCreate, @RequestHeader("id") long id){
        return Apiutils.success(boardService.saveBoard(boardCreate, id));
    }

    @PutMapping(value = "/boards")
    public ApiResult<?> boardUpdate(@RequestBody BoardUpdateRequest boardUpdateRequest, @RequestHeader("id") long id){
        boardService.updateBoard(boardUpdateRequest, id);
        return Apiutils.success("수정 완료");
    }

    @DeleteMapping(value = "/boards")
    public ApiResult<?> boardDelete(@RequestParam("boardId") long boardId, @RequestHeader("id") long id){
        boardService.deleteBoard(boardId, id);
        return Apiutils.success("글 삭제 성공");
    }

    @GetMapping(value="/boards")
    public ApiResult<?> boardList(Pageable pageable){
        return Apiutils.success(boardService.getBoardList(pageable));
    }

    @GetMapping(value="/boards/{boardId}")
    public ApiResult<?> boardDetail(@PathVariable("boardId") long boardId){
        return Apiutils.success(boardService.getBoardDetail(boardId));
    }
}
