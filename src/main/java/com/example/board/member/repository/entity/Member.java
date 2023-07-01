package com.example.board.member.repository.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "member")
@Getter
@Setter
@NoArgsConstructor()
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String memberId;
    private String password;
    private String name;

    public Member(String memberId, String password, String name){
        this.memberId=memberId;
        this.password=password;
        this.name=name;
    }
}
