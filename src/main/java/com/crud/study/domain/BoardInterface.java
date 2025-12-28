package com.crud.study.domain;

import com.crud.study.dto.*;

import java.util.List;

public interface BoardInterface {


    // 게시판 수정
    public void UpdateBoard(BoardUpdateRequestDto requestDTO);
}
