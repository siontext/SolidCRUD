package com.crud.study.dto;

import jakarta.validation.constraints.Size;

// 게시판 생성 요청 DTO
public class BoardCreateRequestDTO {

    // 작성자 이메일
    private final String email;

    // 제목
    @Size(max = 255)
    private final String title;

    // 내용
    @Size(max = 1000)
    private final String content;



    // 생성자
    public BoardCreateRequestDTO( String title, String content, String email){
        this.title = title;
        this.content = content;
        this.email = email;
    }


    // getter
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
