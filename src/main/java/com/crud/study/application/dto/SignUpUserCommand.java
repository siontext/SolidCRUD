package com.crud.study.application.dto;

public record SignUpUserCommand (
        String email,
        String password,
        String passwordAgain,
        String userNm,
        String phoneNum
) {
    public static SignUpUserCommand createOf(String email, String password, String passwordAgain, String userNm, String phoneNum) {
        return new SignUpUserCommand(email, password, passwordAgain, userNm, phoneNum);
    }
}
