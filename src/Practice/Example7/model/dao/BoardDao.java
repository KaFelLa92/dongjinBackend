package Practice.Example7.model.dao;

import Practice.Example7.model.dto.BoardDto;

// CRUD 기능 수행
public class BoardDao {
    // 싱글톤
    private BoardDao() {}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance() {
        return instance;
    }

    // 데이터베이스
    BoardDto[] boardDB = new BoardDto[100];

    // 1. 등록처리
    public boolean boardWrite(BoardDto boardDto){
        for (int i = 0; i < boardDB.length; i++){
            if(boardDB[i] == null){
                boardDB[i] = boardDto;
                return true;
            }
        }
        return false;
    }

    // 2. 조회처리
    public BoardDto[] boardPrint() {
        return boardDB;
    }
}
