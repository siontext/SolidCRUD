package com.crud.study.domain;


import com.crud.study.dto.BoardRequestDTO;
import com.crud.study.dto.BoardResponseDTO;
import com.crud.study.dto.ListBoardResponseDTO;
import com.crud.study.dto.ResponseMessageDTO;

import java.time.LocalDateTime;
import java.util.List;

// 게시판 도메인 엔티티 -> 게시판에 대한 책임을 맏음
public class Board implements BoardInterface{


    // 게시판 ID
    private long id;

    // 유저 이메일
    private String email;

    // 제목
    private String title;

    // 내용
    private String content;

    // 조회수
    private int viewCount;

    // 생성일
    private LocalDateTime createdAt;

    // 수정일
    private LocalDateTime updatedAt;



    // 개시판 생성 생성자
    public Board(BoardRequestDTO requestDTO){
        this.email=requestDTO.getEmail();
        this.title=requestDTO.getTitle();
        this.content=requestDTO.getContent();
        this.createdAt=LocalDateTime.now();
    }


    // 게시판 수정 (찾은 ID + 들어온 수정된 내용들)
    @Override
    public void UpdateBoard(long id, BoardRequestDTO requestDTO){
        this.id= id;
        this.title=requestDTO.getTitle();
        this.content=requestDTO.getContent();
        this.updatedAt=LocalDateTime.now();
    }

    // 게시판 삭제
    @Override
    public ResponseMessageDTO DeleteBoard(BoardRequestDTO requestDTO){
        String message = "{requestDTO.title}게시판 삭제가 완료되었습니다.";

        return new ResponseMessageDTO(message);
    }


    @Override
    public List<ListBoardResponseDTO> ListBoard(){
        return null;
    }

    @Override
    public BoardResponseDTO viewBoard(int BoardNum){
        return null;
    }


    // getter
    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getViewCount() {
        return viewCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
