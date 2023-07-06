package com.example.board.board.dto.response;

import com.example.board.board.repository.entity.Board;
import lombok.Getter;

import java.util.Date;

@Getter
public class BoardListInfo {
    private long boardId;
    private String title;
    private Date createDate;
    private String name;

    public BoardListInfo(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.createDate = board.getCreatedDate();
        this.name = board.getMember().getName();
    }
}
