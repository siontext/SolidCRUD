package com.crud.study.presentation;


import com.crud.study.application.UserService;
import com.crud.study.application.dto.SignUpUserCommand;
import com.crud.study.dto.ResponseMessageDTO;
import com.crud.study.dto.SignUpRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    /** 회원가입 API **/
    @PostMapping
    public ResponseEntity<ResponseMessageDTO> signUpUser(@Valid @RequestBody SignUpRequestDto requestDto) {

        ResponseMessageDTO responseMessageDTO = userService.signUpUser(
                SignUpUserCommand.createOf(requestDto.getEmail(), requestDto.getPassword(), requestDto.getPasswordAgain(), requestDto.getUserNm(), requestDto.getPhoneNum())
        );

        return new ResponseEntity<>(responseMessageDTO, HttpStatus.OK);


    }


}
