package com.example.board.board;

import com.example.board.board.dto.request.BoardDto;
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
    public ApiResult<?> boardCreate(@RequestBody BoardDto boardCreate, @RequestHeader("id") long id){
        try{
            return Apiutils.success(boardService.saveBoard(boardCreate, id));
        }catch(BaseException e){
            throw new BaseException(e.getApiError());
        }
    }

    @PutMapping(value = "/boards")
    public ApiResult<?> boardUpdate(@RequestBody BoardDto boardUpdate){

        return Apiutils.success("글 수정 성공");
    }

    @DeleteMapping(value = "/boards")
    public ApiResult<?> boardDelete(){

        return Apiutils.success("글 삭제 성공");
    }
}
