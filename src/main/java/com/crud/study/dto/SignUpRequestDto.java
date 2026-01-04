package com.crud.study.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

// 회원가입 요청 DTO
public class SignUpRequestDto {

    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    @Email
    @Schema(description = "이메일(id)")
    private String email;

    @NotBlank(message = "비밀번호 입력은 필수입니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)(?=.*[~!@$%^&*_])[a-zA-Z\\d~!@$%^&*_]{8,}$",
            message = "비밀번호는 최소 8자 이상이어야 하며, 소문자, 숫자, 특수 문자(~!@$%^&*_)를 포함해야 합니다.")
    @Schema(description = "비밀번호")
    private String password;


    @NotBlank(message = "비밀번호 재입력은 필수입니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)(?=.*[~!@$%^&*_])[a-zA-Z\\d~!@$%^&*_]{8,}$",
            message = "비밀번호는 최소 8자 이상이어야 하며, 소문자, 숫자, 특수 문자(~!@$%^&*_)를 포함해야 합니다.")
    @Schema(description = "비밀번호 재입력")
    private String passwordAgain;

    @NotBlank(message = "성함을 입력해 주세요")
    private String userNm;

    @NotBlank(message = "핸드폰 번호 입력은 필수입니다.")
    private String phoneNum;




    // getter
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public String getUserNm(){
        return userNm;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

}
