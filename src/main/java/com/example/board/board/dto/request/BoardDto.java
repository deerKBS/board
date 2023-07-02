package com.example.board.board.dto.request;

import com.example.board.board.repository.entity.Board;
import com.example.board.member.repository.entity.Member;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private String title;
    private String content;
    private Member member;

    private long boardId;

    public Board toEntity(){
        Board board = Board.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
        return board;
    }
}
