package com.crud.study.exception;


import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Global Exception Handler에서 발생한 에러에 대한 응답 처리를 관리
 */
public class ErrorResponse {

    private int status;              // 에러 상태 코드
    private String divisionCode;     // 에러 구분 코드
    private String resultMsg;        // 에러 메시지
    private List<FieldError> errors; // 상세 에러 메시지
    private String reason;           // 에러 이유


    /**
     * ErrorResponse 생성자-1
     *
     * @param code ErrorCode
     */
    protected ErrorResponse (final ErrorCode code) {
        this.resultMsg = code.getMessage();
        this.status = code.getStatus();
        this.divisionCode = code.getDivisionCode();
        this.errors = new ArrayList<>();
    }


    /**
     * ErrorResponse 생성자-2
     *
     * @param code   ErrorCode
     * @param reason String
     */
    protected ErrorResponse (final ErrorCode code, final String reason) {
        this.resultMsg = code.getMessage();
        this.status = code.getStatus();
        this.divisionCode = code.getDivisionCode();
        this.reason = reason;
    }

    /**
     * ErrorResponse 생성자-3
     *
     * @param code   ErrorCode
     * @param errors List<FieldError>
     */
    protected ErrorResponse (final ErrorCode code, final List<FieldError> errors) {
        this.resultMsg = code.getMessage();
        this.status = code.getStatus();
        this.errors = errors;
        this.divisionCode = code.getDivisionCode();
    }

    /**
     * Global Exception 전송 타입-1
     *
     * @param code          ErrorCode
     * @param bindingResult BindingResult
     * @return ErrorResponse
     */
    public static ErrorResponse of(final ErrorCode code, final BindingResult bindingResult) {
        return new ErrorResponse(code, FieldError.of(bindingResult));
    }

    /**
     * Global Exception 전송 타입-2
     *
     * @param code ErrorCode
     * @return ErrorResponse
     */
    public static ErrorResponse of(final ErrorCode code) {
        return new ErrorResponse(code);
    }


    /**
     * Global Exception 전송 타입-3
     *
     * @param code   ErrorCode
     * @param reason String
     * @return ErrorResponse
     */
    public static ErrorResponse of(final ErrorCode code, final String reason) {
        return new ErrorResponse(code, reason);
    }

}
