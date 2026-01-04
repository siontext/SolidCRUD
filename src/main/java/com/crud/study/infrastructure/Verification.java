package com.crud.study.infrastructure;

import com.crud.study.application.dto.SignUpUserCommand;
import com.crud.study.dto.SignUpRequestDto;
import org.springframework.stereotype.Component;

// 회원가입 검증 처리하는 얘
@Component
public class Verification {

    // 같은 비밀번호 입력했는지 검증?
    public void checkPassword(SignUpUserCommand command){
        if (!command.password().equals(command.passwordAgain())) {
            throw new IllegalArgumentException("비밀번호와 비밀번호 재입력이 일치하지 않습니다.");
        }

    }

}
