package com.crud.study.dto;

public class BoardSearchListRequestDto {

    private final String email;


    public BoardSearchListRequestDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
