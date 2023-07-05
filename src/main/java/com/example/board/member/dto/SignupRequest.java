package com.example.board.member.dto;

import com.example.board.member.repository.entity.Member;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class SignupRequest {
    @NotBlank(message="아이디를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)[a-z\\d]{6,20}$", message = "아이디 형식이 올바르지 않습니다.")
    private String memberId;

    @NotBlank(message="비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,20}$", message = "비밀번호 형식이 올바르지 않습니다.")
    private String password;

    @NotBlank(message="이름을 입력해주세요.")
    private String name;

    public Member toEntity(){
        Member board = Member.builder()
                .memberId(memberId)
                .password(password)
                .name(name)
                .build();
        return board;
    }
}
