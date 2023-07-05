package com.example.board.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message="id는 필수 입력값입니다.")
    private String memberId;

    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    private String password;
}
