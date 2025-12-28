package com.crud.study.presentation;


import com.crud.study.business.BoardService;
import com.crud.study.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    /** 게시판 생성 API **/
    @PostMapping
    public ResponseEntity<ResponseMessageDTO> createBoard(@RequestBody BoardCreateRequestDTO requestDTO) {

        ResponseMessageDTO responseMessageDTO = boardService.createBoard(requestDTO);

        return new ResponseEntity<>(responseMessageDTO, HttpStatus.OK);

    }

    /** 게시판 수정 API **/
    @PatchMapping
    public ResponseEntity<BoardResponseDTO> updateBoard(@RequestBody BoardUpdateRequestDto requestDTO) {

        BoardResponseDTO responseDTO = boardService.updateBoard(requestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /** 게시판 삭제 API **/
    @DeleteMapping
    public ResponseEntity<ResponseMessageDTO> deleteBoard(@RequestBody BoardDeleteRequestDto requestDTO) {

        ResponseMessageDTO responseMessageDTO = boardService.DeleteBoard(requestDTO);

        return new ResponseEntity<>(responseMessageDTO, HttpStatus.OK);
    }


    /** 이메일로 작성 게시판 전체 조회 API **/
    @GetMapping("/user-email/find-all")
    public ResponseEntity<List<ListBoardResponseDTO>> searchListBoard(@RequestBody BoardSearchListRequestDto requestDTO){

        List<ListBoardResponseDTO> responseDTOS = boardService.SearchListBoard(requestDTO);

        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
    }


    /** 제목으로 게시판 조회 API **/
    @GetMapping("/user-email/find")
    public ResponseEntity<BoardResponseDTO> searchBoard (@RequestBody BoardSearchRequestDto requestDTO) {

        BoardResponseDTO responseDTO = boardService.SearchBoard(requestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
