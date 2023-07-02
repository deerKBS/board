package com.example.board.board.repository.entity;

import com.example.board.member.repository.entity.Member;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private long boardId;

    @ManyToOne // cascade type... 흠..
    @JoinColumn(name = "id")
    private Member member;
    @Column(length = 100, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    @CreationTimestamp
    @Column(name = "create_date")
    private Date createdDate;

    @Builder
    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }
}
