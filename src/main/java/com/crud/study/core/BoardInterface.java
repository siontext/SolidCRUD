package com.crud.study.core;

import com.crud.study.dto.BoardRequestDTO;
import com.crud.study.dto.BoardResponseDTO;
import com.crud.study.dto.ListBoardResponseDTO;
import com.crud.study.dto.ResponseMessageDTO;

import java.util.List;

public interface BoardInterface {


    // 게시판 수정
    public void UpdateBoard(long id, BoardRequestDTO requestDTO);

    // 게시판 삭제
    public ResponseMessageDTO DeleteBoard(BoardRequestDTO requestDTO);

    // 게시판 리스트 조회 (유저 아이디로 일단 모두 조회하고 -> 리스트 응답을 프론트에서 페이지네이션 해주면 될듯?)
    public List<ListBoardResponseDTO> ListBoard();

    // 게시판 상세 조회 (게시판 pk받아서조회하면됨)
    public BoardResponseDTO viewBoard(int BoardNum);

}
