package com.example.board.member.service;

import com.example.board.config.BaseException;
import com.example.board.member.dto.LoginRequest;
import com.example.board.member.repository.MemberRepository;
import com.example.board.member.repository.entity.Member;
import com.example.board.util.ApiError;
import com.example.board.util.Apiutils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public Member login(LoginRequest loginRequest){
        Optional<Member> members = memberRepository.findByMemberId(loginRequest.getMemberId());

        Member member = members.orElseThrow(()-> new BaseException(new ApiError("존재하지 않는 id 또는 password가 일치하지 않습니다", 1002)));

        if(member.getPassword().equals(loginRequest.getPassword())){
            return member;
        }

        throw new BaseException(new ApiError("존재하지 않는 id 또는 password가 일치하지 않습니다", 1002));
    }
}
