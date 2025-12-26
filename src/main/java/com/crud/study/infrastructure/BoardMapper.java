package com.crud.study.infrastructure;

import com.crud.study.domain.Board;
import com.crud.study.dto.BoardRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


//JAP 인터페이스 처럼 필요한 조회 메서드 작성 -> 조회 메서드 구현은 xml에서
@Mapper
public interface BoardMapper {

    /** 게시판 생성 **/
    // 게시판 생성 sql
    public void createBoardSql(Board board);


    /** 게시판 수정, 삭제 **/
    // 이메일 + 제목으로 게시판 id조회
    public long findBoardIdSql(BoardRequestDTO requestDTO);

    // id로 게시판 조회
    public Board findBoardSql(@Param("id") long id);

    // 수정된 게시판 저장
    public Board saveUpdateBoardSql(Board board);

    // 게시판 삭제 (id로)
    public void deleteBoardSql(long id);

    // 이메일로 사용자가 작성한 게시판 모두 조회
    public List<Board> findAllBoardByEmailSql(String email);
    
    // 제목으로 게시판 상세 조회
    public Board findBoardTitleSql(String title);

}
