package com.example.board.login.service;

import com.example.board.config.BaseException;
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

    public Member login(String memberId, String password){
        Optional<Member> members = memberRepository.findByMemberId(memberId);

        if(members.isEmpty()){
            throw new BaseException(new ApiError("존재하지 않는 id 입니다.", 1002));
        }

        Member member = members.get();
        if(members.get().getPassword().equals(password)){
            return member;
        }

        throw new BaseException(new ApiError("비밀번호가 일치하지 않습니다.", 1003));
    }
}
