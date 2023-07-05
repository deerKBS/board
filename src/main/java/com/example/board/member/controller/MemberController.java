package com.example.board.member.controller;

import com.example.board.config.BaseException;
import com.example.board.member.dto.SignupRequest;
import com.example.board.member.repository.entity.Member;
import com.example.board.member.service.MemberService;
import com.example.board.util.ApiResult;
import com.example.board.util.Apiutils;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/member/signup")
    public ApiResult<?> signup(@RequestBody @Valid SignupRequest signupRequest){
        memberService.register(signupRequest);
        return Apiutils.success("회원가입 성공");
    }

    @GetMapping(value="/member/checkId")
    public ApiResult<?> checkId(@RequestParam("memberId") String memberId){
        memberService.checkDuplicate(memberId);
        return Apiutils.success("사용가능한 id 입니다.");
    }
}
