package Example7.Practice.controller;

import Example7.Practice.model.dao.BoardDao;
import Example7.Practice.model.dto.BoardDto;

public class BoardControl {

    // 싱글톤
    private BoardControl(){}
    private static final BoardControl control = new BoardControl();
    public static BoardControl getInstance();{
        return control;
    }

    // Dao 싱글톤(객체) 가져오기
    private BoardDao boardDao = BoardDao.getInstance();

    // 1. 등록 처리 , Dto 가져와서 매개변수 객체화하고 D
    public boolean boardWrite(String content, String writer){
        BoardDto boardDto = new BoardDto(content , writer);
        boolean result = boardDao.boardWrite(boardDto);
        return result;
    }

    // 2. 조회 처리
    public BoardDto[] boardPrint(){
        BoardDto[] result = boardDao.boardPrint();
        return result;
    }

}
