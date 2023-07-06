package com.example.board.board.controller;

import com.example.board.board.dto.request.BoardCreateRequest;
import com.example.board.board.dto.request.BoardUpdateRequest;
import com.example.board.board.service.BoardService;
import com.example.board.util.ApiResult;
import com.example.board.util.Apiutils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public ApiResult<?> boardCreate(
            @RequestBody BoardCreateRequest boardCreate,
            @RequestHeader long id
    ) {
        return Apiutils.success(boardService.saveBoard(boardCreate, id));
    }

    @PutMapping("/boards/{boardId}")
    public ApiResult<?> boardUpdate(
            @PathVariable long boardId,
            @RequestBody BoardUpdateRequest boardUpdateRequest,
            @RequestHeader long id
    ) {
        boardService.updateBoard(boardId, boardUpdateRequest, id);
        return Apiutils.success("수정 완료");
    }

    @DeleteMapping("/boards/{boardId}")
    public ApiResult<?> boardDelete(
            @PathVariable long boardId,
            @RequestHeader long id
    ) {
        boardService.deleteBoard(boardId, id);
        return Apiutils.success("글 삭제 성공");
    }

    @GetMapping("/boards")
    public ApiResult<?> boardList(
            Pageable pageable
    ) {
        return Apiutils.success(boardService.getBoardList(pageable));
    }

    @GetMapping("/boards/{boardId}")
    public ApiResult<?> boardDetail(
            @PathVariable long boardId
    ) {
        return Apiutils.success(boardService.getBoardDetail(boardId));
    }
}
