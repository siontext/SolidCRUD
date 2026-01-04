package com.crud.study.application;

import com.crud.study.application.dto.SignUpUserCommand;
import com.crud.study.domain.HashEncoder;
import com.crud.study.domain.User;
import com.crud.study.dto.ResponseMessageDTO;
import com.crud.study.infrastructure.UserMapper;
import com.crud.study.infrastructure.Verification;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final HashEncoder hashEncoder;
    private final Verification verification;

    public UserService(UserMapper userMapper, HashEncoder hashEncoder, Verification verification) {
        this.userMapper = userMapper;
        this.hashEncoder = hashEncoder;
        this.verification = verification;
    }

    public ResponseMessageDTO signUpUser(SignUpUserCommand command) {

        verification.checkPassword(command);

        if (userMapper.countByEmail(command.email()) > 0) {
            throw new RuntimeException("이미 사용 중인 이메일입니다.");
        }

        String hashEmail = hashEncoder.hashEncode(command.email());
        String hashPhoneNum = hashEncoder.hashEncode(command.phoneNum());

        User user = new User(hashEmail, command.email(), command.password(), hashPhoneNum);

        userMapper.insertUser(user);

        String message = "회원가입이 완료되었습니다.";

        return new ResponseMessageDTO(message);
    }
}
