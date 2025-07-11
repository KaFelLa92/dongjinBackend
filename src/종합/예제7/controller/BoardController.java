package 종합.예제7.controller;

import 종합.예제7.model.dao.BoardDao;
import 종합.예제7.model.dto.BoardDto;

// (역할) view와 model(dta, dao)의 중간제어
public class BoardController {
    
    // Controller 싱글톤 만들기 (DTO 빼고는 다 싱글톤 필요하다니깐?)
    private BoardController(){} // 1단계
    private static final BoardController control = new BoardController(); // 2단계
    public static BoardController getInstance() {
        return control; // 3단계
    }

    // DAO (싱글톤) 객체 가져오기
    private BoardDao boardDao = BoardDao.getInstance();

    // 1. 등록 처리 메소드 : 
    // view에서 전달받은 content, writer 객체로 구성하여 dao에게 전달 후 결과를 view에게 전달
    public boolean boardWrite(String content, String writer) {
        BoardDto boardDto
                = new BoardDto(content, writer); // 1) 매개변수 객체화
        boolean result = boardDao.boardWrite(boardDto);  // (2) dao에게 객체 전달 후 결과 받기
        return result;                  // (3) dao에게 받은 결과를 view에게 반환하기
    }

    // 2. 조회 처리 메소드
    public BoardDto[] boardPrint() { // 반환 타입 배열
        BoardDto[] result = boardDao.boardPrint(); // DAO에게 게시물 조회 요청후 반환값을 저장한다.
        return result;// dio에게 받은 결과 반환
    }
}   // class end
