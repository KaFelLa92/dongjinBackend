package Practice.Example9.controller;

import Practice.Example9.model.dao.BoardDao;
import Practice.Example9.model.dto.BoardDto;


import java.util.ArrayList;

public class BoardController {
    // (*) 싱글톤 생성
    private BoardController (){}
    public static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }
    
    // (*) Dao 싱글톤 호출
    private BoardDao boardDao = BoardDao.getInstance();
    
    // (1) 등록
    public boolean boardWrite( String content , String writer ){
        BoardDto boardDto = new BoardDto( content , writer);
        boolean result = boardDao.boardWrite(boardDto);
        return result;
    } // func end
    
    // (2) 전체조회
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> result = boardDao.boardPrint();
        return result;
    }


}
