package com.example.board.board.repository;

import com.example.board.board.repository.entity.Board;
import com.example.board.board.repository.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
