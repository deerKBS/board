package com.example.board.board.service;

import com.example.board.board.dto.request.BoardDto;
import com.example.board.board.repository.BoardRepository;
import com.example.board.board.repository.entity.Board;
import com.example.board.config.BaseException;
import com.example.board.member.repository.MemberRepository;
import com.example.board.member.repository.entity.Member;
import com.example.board.util.ApiError;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public long saveBoard(BoardDto boardDto, long id){
        Optional<Member> members = memberRepository.findById(id);
        if(members.isEmpty()){
            throw new BaseException(new ApiError("존재하지 않는 id 입니다.", 1005));
        }
        Member member = members.get();
        boardDto.setMember(member); // 작성자

        Board board = boardDto.toEntity();
        Board board1 = boardRepository.save(board);
        return board1.getBoardId();
    }

    public void updateBoard(BoardDto boardDto, long id){


    }

    public void deleteBoard(){

    }

    public void BoardList(){

    }

    public void BoardDetail(){

    }
}
