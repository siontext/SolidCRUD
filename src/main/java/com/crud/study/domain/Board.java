package com.crud.study.domain;


import com.crud.study.dto.*;

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



    // 게시판 생성 생성자
    /**
     * Domain 레이어와 <-> DTO 레이어를 분리해야 하는건가요?
     * 즉 도메인에서 생성자를 만들거나 핵심 비즈니스 로직을 만들때 -> 도메인에서 RequestDTO 사용 하면 안되는 것인가요? 왜 그래야 하는지 모르겠다 ㅠㅠ
     * **/
    public Board(long id, String email, String title, String content, int viewCount, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.id=id;
        this.email=email;
        this.title=title;
        this.content=content;
        this.viewCount=viewCount;
        this.createdAt=LocalDateTime.now();
        this.updatedAt=updatedAt;
    }

    public Board(String email, String title, String content) {
        this.email=email;
        this.title=title;
        this.content=content;
    }


    // 게시판 수정 (찾은 ID + 들어온 수정된 내용들)
    /**
     * 그러면 얘도 잘못된건가? (핵심 비즈니스 로직)
     * **/
    @Override
    public void UpdateBoard(BoardUpdateRequestDto requestDTO){
        this.title=requestDTO.getTitle();
        this.content=requestDTO.getContent();
        this.updatedAt=LocalDateTime.now();
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
