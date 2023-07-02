package com.example.board.board.dto.request;

import com.example.board.board.repository.entity.Board;
import com.example.board.member.repository.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardCreateRequest {
    private String title;
    private String content;

    public Board toEntity(){
        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();
        return board;
    }
}
