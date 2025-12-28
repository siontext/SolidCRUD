package com.crud.study.dto;

import com.crud.study.domain.Board;

public class BoardUpdateRequestDto {

    private long id;

    private String title;

    private String content;


    public BoardUpdateRequestDto(Board board){
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }

    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }
}
