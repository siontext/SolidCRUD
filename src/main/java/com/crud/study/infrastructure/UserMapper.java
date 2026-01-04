package com.crud.study.infrastructure;

import com.crud.study.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//JAP 인터페이스 처럼 필요한 조회 메서드 작성 -> 조회 메서드 구현은 xml에서
@Mapper
public interface UserMapper {

    // 회원가입시 입력된 이메일 중복 검사. SQL
    int countByEmail(@Param("email") String email);


    // 유저정보 DB 저장 SQL (회원가입)
    void insertUser (User user);

    // 이메일로 유저 찾기


}
