package com.crud.study.exception;


import java.util.List;

/**
 * Global Exception Handler에서 발생한 에러에 대한 응답 처리를 관리
 */
public class ErrorResponse {

    private int status;             // 에러 상태 코드
    private String divisionCode;    // 에러 구분 코드
    private String resultMsg;       // 에러 메시지
    private List<> errors;
    private String reason;
}
