package com.example.board.board.dto.response;

import com.example.board.member.repository.entity.Member;
import lombok.*;

import java.util.Date;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardListInfo {
    private long boardId;
    private String title;
    private Date createDate;
    private String name;
}
