package com.example.board.board.dto.response;

import com.example.board.board.repository.entity.Board;
import com.example.board.member.repository.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDetail {
    private long boardId;
    private String title;
    private String content;
    private Date createDate;
    private long writerId;
    private String writerName;

    public BoardDetail(Board board){
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createDate = board.getCreatedDate();
        this.writerId = board.getBoardId();
        this.writerName = board.getMember().getName();
    }
}
