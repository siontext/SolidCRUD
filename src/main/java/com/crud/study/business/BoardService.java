package com.crud.study.business;

import com.crud.study.core.Board;
import com.crud.study.dto.BoardRequestDTO;
import com.crud.study.dto.BoardResponseDTO;
import com.crud.study.dto.ListBoardResponseDTO;
import com.crud.study.dto.ResponseMessageDTO;
import com.crud.study.infrastructure.BoardMapper;

import java.util.List;


/*** 서비스에서 컨트롤러 반환할때 -> DTO에 담아줘야제?  (수정할거 많음)
 *
 *
 *
 * **/
public class BoardService {

    private final BoardMapper boardMapper;


    public BoardService(BoardMapper boardMapper){
        this.boardMapper=boardMapper;
    }


    /*** 게시판 생성 (비즈니스 로직은 도메인이 처리)**/
    public ResponseMessageDTO createBoard (BoardRequestDTO requestDTO){

        // 게시판 객체 생성 (핵심 비즈니스 로직 DDD)
        Board board = new Board(requestDTO);

        // 생성된 객체 -> DB 저장
        boardMapper.createBoardSql(board);

        String message = "게시판 생성 완료되었습니다.";

        // DTO 에 응답 메시지 담아서 보내주기
        return new ResponseMessageDTO(message);
    }

    /** 게시판 수정**/
    public BoardResponseDTO updateBoard(BoardRequestDTO requestDTO){

        // 이메일 + 제목으로 게시판 id찾기 (클라이언트가 게시판 id는 따로 안준다는 가정)
        long findBoardId = boardMapper.findBoardIdSql(requestDTO);

        // ID로 게시판 찾기
        Board findBoard = boardMapper.findBoardSql(findBoardId);

        // 게시판 내용 변경 (핵심 비즈니스 로직 DDD) (찾은 게시판 ID + 리퀘스트에 담긴 수정내용)
        findBoard.UpdateBoard(findBoardId, requestDTO);

        // 변경된 내용 저장 -> DB 저장 + 객체 반환
        Board saveBoard = boardMapper.saveUpdateBoardSql(findBoard);

        // 변경된 내용을 담아 -> DTO 객체 생성 및 담아주고 -> 반환
        return new BoardResponseDTO(saveBoard);
    }

    /*** 게시판 삭제  -> 조회 + 삭제가 인프라 계층에서 이뤄지는 작업이다 보니 도메인객체가 따로 처리할 비즈니스 로직은 없어 보입니다.**/
    public ResponseMessageDTO DeleteBoard(BoardRequestDTO requestDTO){

        // 삭제할 게시판 조회 (클라이언트가 삭제할 게시판 id를 DTO로 보내주겠죠?)
        Board board = boardMapper.findBoardSql(requestDTO.getId()); // 없으면 오류라고 해주기 -> 익셉션 추가(글로벌 익셉션)

        // 게시판 삭제 (id가져와서)
        boardMapper.deleteBoardSql(board.getId());

        // 메시지 DTO에 담아서 반환
        return board.DeleteBoard(requestDTO);
    }


    /*** 유저가 작성한 게시판 리스트 전체 조회 **/
    public List<ListBoardResponseDTO> SearchListBoard(BoardRequestDTO requestDTO){

        // 유저 이메일로 작성한 게시판 전체 찾기

        // 게시판 객체를 ->

        return null;
    }

    // 특정 게시판 상세 조회

}
