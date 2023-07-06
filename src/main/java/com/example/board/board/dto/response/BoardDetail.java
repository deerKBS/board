package com.example.board.board.dto.response;

import com.example.board.board.repository.entity.Board;
import lombok.Getter;

import java.util.Date;

@Getter
public class BoardDetail {
    private long boardId;
    private String title;
    private String content;
    private Date createDate;
    private long writerId;
    private String writerName;

    public BoardDetail(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createDate = board.getCreatedDate();
        this.writerId = board.getBoardId();
        this.writerName = board.getMember().getName();
    }
}
