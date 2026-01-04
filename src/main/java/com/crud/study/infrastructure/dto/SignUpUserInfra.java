package com.crud.study.infrastructure.dto;

import com.crud.study.application.dto.SignUpUserCommand;

public record SignUpUserInfra (
        String email,
        String password,
        String passwordAgain,
        String userNm,
        String phoneNum
) {
    public static SignUpUserInfra createOf(String email, String password, String passwordAgain, String userNm, String phoneNum) {
        return new SignUpUserInfra(email, password, passwordAgain, userNm, phoneNum);
    }
}