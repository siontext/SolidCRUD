package com.crud.study.dto;


import com.crud.study.core.Board;

import java.sql.Timestamp;
import java.time.LocalDateTime;

// 게시판 조회, 상세 조회에 대한 DTO
public class BoardResponseDTO {

    // 게시판 id
    private final Long id;

    // 유저 email
    private final String email;

    // 제목
    private final String title;

    // 내용
    private final String content;

    // 생성일자
    private final LocalDateTime createTime;

    // 수정일자
    private final LocalDateTime updateTime;


    public BoardResponseDTO(Board board){
        this.id= board.getId();
        this.email= board.getEmail();
        this.title= board.getTitle();
        this.content= board.getContent();
        this.createTime=board.getCreatedAt();
        this.updateTime=board.getUpdatedAt();
    }

}
