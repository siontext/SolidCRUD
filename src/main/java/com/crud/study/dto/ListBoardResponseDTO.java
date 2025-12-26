package com.crud.study.dto;

import com.crud.study.domain.Board;

import java.sql.Timestamp;
import java.time.LocalDateTime;

// 게시판 리스트조회 응답
public class ListBoardResponseDTO {

    // 게시판 PK
    private final long id;

    // 제목
    private final String title;

    // 작성자 메일
    private final String email;

    // 조회수
    private final String viewCount;

    // 수정날짜
    private final LocalDateTime updateTime;

    public ListBoardResponseDTO (Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.email = board.getEmail();
        this.viewCount = board.getContent();
        this.updateTime = board.getUpdatedAt();
    }


}
