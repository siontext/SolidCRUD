package com.crud.study.business;

import com.crud.study.domain.Board;
import com.crud.study.dto.*;
import com.crud.study.infrastructure.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BoardService {

    private final BoardMapper boardMapper;


    public BoardService(BoardMapper boardMapper){
        this.boardMapper=boardMapper;
    }


    /*** 게시판 생성 (비즈니스 로직은 도메인이 처리)**/
    public ResponseMessageDTO createBoard (BoardCreateRequestDTO requestDTO){

        // 게시판 객체 생성 (핵심 비즈니스 로직 DDD)
        Board board = new Board(requestDTO.getEmail(), requestDTO.getTitle(), requestDTO.getContent());

        // 생성된 객체 -> DB 저장
        boardMapper.createBoardSql(board);

        String message = "게시판 생성 완료되었습니다.";

        // DTO 에 응답 메시지 담아서 보내주기
        return new ResponseMessageDTO(message);
    }

    /** 게시판 수정**/
    public BoardResponseDTO updateBoard(BoardUpdateRequestDto requestDTO){

        // ID로 게시판 찾기
        Board findBoard = boardMapper.findBoardSql(requestDTO.getId());

        // 게시판 내용 변경 (핵심 비즈니스 로직 DDD) (찾은 게시판 ID + 리퀘스트에 담긴 수정내용)
        findBoard.UpdateBoard(requestDTO);

        // 변경된 내용 저장 -> DB 저장 + 객체 반환
        Board saveBoard = boardMapper.saveUpdateBoardSql(findBoard);

        // 변경된 내용을 담아 -> DTO 객체 생성 및 담아주고 -> 반환
        return new BoardResponseDTO(saveBoard);
    }

    /*** 게시판 삭제  -> 조회 + 삭제가 인프라 계층에서 이뤄지는 작업이다 보니 도메인객체가 따로 처리할 비즈니스 로직은 없어 보입니다.**/
    public ResponseMessageDTO DeleteBoard(BoardDeleteRequestDto requestDTO){

        // 게시판 삭제 (핵심 비즈니스 로직 -> 그러나 DB 작업이기 때문에 인프라 레이어에서 처리)
        boardMapper.deleteBoardSql(requestDTO.getId());

        String message =  "{requestDTO.title}게시판 삭제가 완료되었습니다.";

        // 메시지 DTO에 담아서 반환
        return new ResponseMessageDTO(message);
    }


    /*** 유저가 작성한 게시판 리스트 전체 조회 **/
    public List<ListBoardResponseDTO> SearchListBoard(String email){

        // 유저 이메일로 조회한 전체 게시판 객체 리스트
        List<Board> boards = boardMapper.findAllBoardByEmailSql(email);

        // 게시판 객체 리스트를 -> DTO List에 담아주기
        List<ListBoardResponseDTO> boardResponseDTOS = new ArrayList<>();
        for (Board board : boards){
            boardResponseDTOS.add(new ListBoardResponseDTO(board));
        }

        // 변환된 DTO 리스트 반환하기
        return boardResponseDTOS;
    }

    /** 특정 게시판 상세 조회 (제목을 통해) **/
    public BoardResponseDTO SearchBoard(String title){

        // 제목으로 게시글 조회
        Board board = boardMapper.findBoardTitleSql(title);

        // 조회된 게시글 DTO에 담아서 반환
        return new BoardResponseDTO(board);

    }

}
