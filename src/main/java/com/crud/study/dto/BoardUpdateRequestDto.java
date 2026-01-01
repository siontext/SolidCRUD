package com.crud.study.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;

public class BoardUpdateRequestDto {

    private long id;

    @Size(max = 255)
    private String title;

    @Size(max = 1000)
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
