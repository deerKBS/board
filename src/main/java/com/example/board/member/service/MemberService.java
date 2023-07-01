package com.example.board.member.service;

import com.example.board.config.BaseException;
import com.example.board.member.repository.MemberRepository;
import com.example.board.member.repository.entity.Member;
import com.example.board.util.ApiError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void register(Member member){
        Optional<Member> members = memberRepository.findByMemberId(member.getMemberId()); // 중복검사
        if(members.isPresent()){
            throw new BaseException(new ApiError("존재하는 id입니다.", 1000));
        }

        Member member1 = memberRepository.save(member); // 저장
        if(member.getMemberId().equals(member1.getMemberId())){ // 한번 더 확인
            return;
        }
        throw new BaseException(new ApiError("회원가입 과정에서 문제가 발생하였습니다.", 1001));
    }
}
