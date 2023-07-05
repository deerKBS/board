package com.example.board.member.service;

import com.example.board.config.BaseException;
import com.example.board.member.dto.SignupRequest;
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

    public void register(SignupRequest signupRequest){
        Member member = signupRequest.toEntity();
        boolean isExist = memberRepository.existsByMemberId(member.getMemberId()); // 중복검사
        if(isExist){
            throw new BaseException(new ApiError("존재하는 id 입니다.", 1000));
        }

        if(member.getMemberId().equals(memberRepository.save(member).getMemberId())){ // 저장 & 한번 더 확인
            return;
        }
        throw new BaseException(new ApiError("회원가입 과정에서 문제가 발생하였습니다.", 1001));
    }

    public void duplicateCheck(String memberId){
        boolean isExist = memberRepository.existsByMemberId(memberId);

        if(isExist){
            throw new BaseException(new ApiError("존재하는 id 입니다.",1008));
        }
    }
}
