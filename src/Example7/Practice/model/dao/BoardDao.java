package Example7.Practice.model.dao;

import 종합.예제7.model.dto.BoardDto;

public class BoardDao {

    // 싱글톤
    private BoardDao() {}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance() {
        return instance;
    }

    // DB
    BoardDto[] boardDB = new BoardDto[100];

    // 1. 등록처리
    public boolean boardWrite(BoardDto boardDto){
        for ( int i = 0; i < boardDB.length; i++){
            if( boardDB[i] == null){
                boardDB[i] = boardDto;
                return true;
            }
        }
        return false;
    }

    // 2. 조회처리
    public BoardDto[] boardPrint(){
        return boardDB;
    }

}
