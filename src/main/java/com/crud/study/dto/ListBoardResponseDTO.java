package com.crud.study.dto;

import java.sql.Timestamp;

// 게시판 리스트조회 응답
public class ListBoardResponseDTO {

    // 작성자명
    private final String userNm;

    // 작성자 메일
    private final String email;

    // 제목
    private final String title;

    // 조회수
    private final String viewCount;

    // 수정날짜
    private final Timestamp updateTime;


    public ListBoardResponseDTO(String userNm, String email, String title, String viewCount, Timestamp updateTime){
        this.userNm = userNm;
        this.email = email;
        this.title = title;
        this.viewCount = viewCount;
        this.updateTime = updateTime;
    }
}
