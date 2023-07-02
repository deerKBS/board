package com.example.board.board.dto.response;

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
}
