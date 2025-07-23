package 종합.예제10.controller;

import 종합.예제10.model.dao.BoardDao;
import 종합.예제10.model.dto.BoardDto;

public class BoardController {
    // (*) 싱글톤
    private BoardController (){}
    public static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }

    // (*) BoardDto 싱글톤 가져오기
    private BoardDao boardDao = BoardDao.getInstance();

    // (1) 등록 기능 구현
    public boolean boardWrite( String bcontent , String bwriter ){
        // 1. 여러개 유효성 검사 (패스)
        // 2. 데이터문제 없으면 묶음(객체) 하나로 만들기
        // -> 주의할점 매개변수와 동일한 생성자가 존재하지 않으면 오류 발생한다.
        BoardDto boardDto = new BoardDto(0 ,bcontent , bwriter);
        // 3. 객체화 된 dto를 dao에게 전달후 결과를 받는다.
        boolean result = boardDao.boardWrite( boardDto );
        // 4. 결과를 view에게 리턴한다.
        return result;
    }


} // class end
