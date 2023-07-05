package com.example.board.member.controller;

import com.example.board.config.BaseException;
import com.example.board.member.dto.SignupRequest;
import com.example.board.member.repository.entity.Member;
import com.example.board.member.service.MemberService;
import com.example.board.util.ApiResult;
import com.example.board.util.Apiutils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/signup")
    public ApiResult<?> signup(@RequestBody @Valid SignupRequest signupRequest){
        System.out.println(signupRequest.getMemberId()+", "+signupRequest.getPassword());
        try{
            Member member = new Member(signupRequest.getMemberId(), signupRequest.getPassword(), signupRequest.getName());
            memberService.register(member);
            return Apiutils.success("회원가입 성공");
        }catch (BaseException e){
            throw new BaseException(e.getApiError());
        }
    }
}
