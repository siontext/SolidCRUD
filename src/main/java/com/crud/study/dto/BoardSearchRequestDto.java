package com.crud.study.dto;

public class BoardSearchRequestDto {

    private final String title;

    public BoardSearchRequestDto(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
