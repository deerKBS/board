package com.example.board.board.repository;


import com.example.board.board.dto.response.BoardListInfo;
import com.example.board.board.repository.entity.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT new com.example.board.board.dto.response.BoardListInfo(b.boardId, b.title, b.createdDate, m.name) FROM Board b JOIN b.member m")
    public List<BoardListInfo> findAllBoards(Pageable pageable);
}
