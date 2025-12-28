package com.crud.study.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoardUpdateRequestDto {

    private long id;

    private String title;

    private String content;



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
