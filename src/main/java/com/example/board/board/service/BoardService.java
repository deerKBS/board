package com.example.board.board.service;

import com.example.board.board.dto.request.BoardCreateRequest;
import com.example.board.board.dto.request.BoardUpdateRequest;
import com.example.board.board.dto.response.BoardDetail;
import com.example.board.board.dto.response.BoardListInfo;
import com.example.board.board.repository.BoardRepository;
import com.example.board.board.repository.entity.Board;
import com.example.board.config.BaseException;
import com.example.board.member.repository.MemberRepository;
import com.example.board.member.repository.entity.Member;
import com.example.board.util.ApiError;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public long saveBoard(BoardCreateRequest boardCreateRequest, long id){
        Member member = memberRepository.findById(id).orElseThrow(()->new BaseException(new ApiError("존재하지 않는 id 입니다.", 1005)));

        Board board = boardCreateRequest.toEntity();
        board.setMember(member);
        Board board1 = boardRepository.save(board);
        return board1.getBoardId();
    }

    public void updateBoard(long boardId, BoardUpdateRequest boardUpdateRequest, long id){
        Board board = boardRepository.findById(boardId).orElseThrow(()->new BaseException(new ApiError("존재하지 않는 게시글입니다.", 1008)));

        if (board.getMember().getId() == id) {
            board.setTitle(boardUpdateRequest.getTitle());
            board.setContent(boardUpdateRequest.getContent());
            boardRepository.save(board);
            return;
        }
        throw new BaseException(new ApiError("작성자와 사용자가 일치하지 않습니다", 1006));
    }

    public void deleteBoard(long boardId, long id){
        Board board = boardRepository.findById(boardId).orElseThrow(()->new BaseException(new ApiError("존재하지 않는 게시글입니다.", 1008)));
        if(board.getMember().getId()==id){
            boardRepository.delete(board);
            return;
        }
        throw new BaseException(new ApiError("작성자와 사용자가 일치하지 않습니다.", 1007));
    }

    public List<BoardListInfo> getBoardList(Pageable pageable){
        List<Board> resultList = boardRepository.findAllBoards(pageable);

        return resultList.stream()
                .map(BoardListInfo::new)
                .collect(Collectors.toList());
    }

    public BoardDetail getBoardDetail(long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(()->new BaseException(new ApiError("존재하지 않는 게시글입니다.", 1008)));
        return new BoardDetail(board);
    }
}
