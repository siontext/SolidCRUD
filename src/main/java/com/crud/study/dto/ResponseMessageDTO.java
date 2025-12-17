package com.crud.study.dto;

public class ResponseMessageDTO {

    private final String message;


    
    // 생성자
    public ResponseMessageDTO (String message) {
        this.message=message;
    }


    // getter
    public String getMessage(){
        return message;
    }

}
