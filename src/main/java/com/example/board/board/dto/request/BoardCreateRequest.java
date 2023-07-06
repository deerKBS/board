package com.example.board.board.dto.request;

import com.example.board.board.repository.entity.Board;
import lombok.Getter;

@Getter
public class BoardCreateRequest {
    private String title;
    private String content;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
