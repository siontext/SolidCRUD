package com.crud.study.dto;

import java.sql.Timestamp;

// 게시판 관련 요청 DTO
public class BoardRequestDTO {

    // 게시판 id
    private final long id;

    // 작성자명
    private final String email;

    // 제목
    private final String title;

    // 내용
    private final String content;



    // 생성자
    public BoardRequestDTO (int id, String title, String content, String email){
        this.id = id;
        this.title = title;
        this.content = content;
        this.email = email;
    }


    // getter
    public long getId(){
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

}
