package com.crud.study.domain;

import java.time.LocalDateTime;

public class User {


    //이메일 (id)
    private String email;

    // 비밀번호
    private String password;

    // 유저 이름
    private String userNm;

    // 폰번호
    private String phoneNum;

    // 생성일
    private LocalDateTime createdAt;

    // 수정일
    private LocalDateTime updatedAt;


    // 비밀번호 해시화?

    // 비밀번호 역 해시화?





    public User(String email, String password, String userNm, String phoneNum){
        this.email=email;
        this.password=password;
        this.userNm=userNm;
        this.phoneNum=phoneNum;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserNm(){
        return userNm;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }



}
