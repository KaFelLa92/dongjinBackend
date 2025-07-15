package practice.Example7.controller;

import practice.Example7.model.dao.BoardDao;
import practice.Example7.model.dto.BoardDto;


// view와 model 중간 제어 역할
public class BoardController {
    // 싱글톤
    private BoardController(){}
    private static final BoardController control = new BoardController();
    public static BoardController getInstance() {
        return control;
    }

    // DAO 가져오기
    private BoardDao boardDao = BoardDao.getInstance();

    // 1. 메소드 등록처리
    public boolean boardWrite(String content, String writer){
        BoardDto boardDto = new BoardDto(content, writer);
        boolean result = boardDao.boardWrite(boardDto);
        return result;
    }

    // 2. 메소드 조회처리
    public BoardDto[] boardPrint(){
        BoardDto[] result = boardDao.boardPrint();
        return result;
    }

}
