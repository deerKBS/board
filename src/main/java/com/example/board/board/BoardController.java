package com.example.board.board;

import com.example.board.board.dto.request.BoardCreateRequest;
import com.example.board.board.dto.request.BoardUpdateRequest;
import com.example.board.board.service.BoardService;
import com.example.board.config.BaseException;
import com.example.board.util.ApiResult;
import com.example.board.util.Apiutils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @PostMapping(value = "/boards")
    public ApiResult<?> boardCreate(@RequestBody BoardCreateRequest boardCreate, @RequestHeader("id") long id){
        try{
            return Apiutils.success(boardService.saveBoard(boardCreate, id));
        }catch(BaseException e){
            throw new BaseException(e.getApiError());
        }
    }

    @PutMapping(value = "/boards")
    public ApiResult<?> boardUpdate(@RequestBody BoardUpdateRequest boardUpdateRequest, @RequestHeader("id") long id){
        try {
            boardService.updateBoard(boardUpdateRequest, id);
            return Apiutils.success("수정 완료");
        }catch(BaseException e){
            throw new BaseException(e.getApiError());
        }
    }

    @DeleteMapping(value = "/boards")
    public ApiResult<?> boardDelete(@RequestParam("boardId") long boardId, @RequestHeader("id") long id){
        try{
            boardService.deleteBoard(boardId, id);
            return Apiutils.success("글 삭제 성공");
        }catch(BaseException e){
            throw new BaseException(e.getApiError());
        }
    }

    @GetMapping(value="/boards")
    public ApiResult<?> boardList(@RequestParam("page") int page, @RequestParam("size") int size){
        try{
            return Apiutils.success(boardService.BoardList(page, size));
        }catch(BaseException e){
            throw new BaseException(e.getApiError());
        }
    }

    @GetMapping(value="/boards/{boardId}")
    public ApiResult<?> boardDetail(@PathVariable("boardId") long boardId){
        try{
            return Apiutils.success(boardService.BoardDetail(boardId));
        }catch(BaseException e){
            throw new BaseException(e.getApiError());
        }
    }

}
