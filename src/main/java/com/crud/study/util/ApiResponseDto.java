package com.crud.study.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseDto {

    private final String message;
    private final String data;




    // 공통 응답 ResponseEntityDTO
    public static ResponseEntity<ApiResponseDto> responseEntity(HttpStatus httpStatus, String message, String data){

        ApiResponseDto responseDto = new ApiResponseDto(message, data);
        System.out.println(responseDto); // 한번 보자 잘 오는지

        return ResponseEntity.status(httpStatus).body(responseDto);
    }



    // 생성자
    public ApiResponseDto(String message, String data){
        this.message=message;
        this.data=data;
    }


}
