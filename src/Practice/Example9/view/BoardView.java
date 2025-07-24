package Practice.Example9.view;

import Practice.Example9.controller.BoardController;

import java.util.Scanner;

public class BoardView {
    // (*) 싱글톤 생성
    private BoardView (){}
    public static final BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    }

    // (*) 스캐너 객체
    private Scanner scan = new Scanner(System.in);

    // (*) 컨트롤러 싱글톤 호출
    private BoardController boardController = BoardController.getInstance();

    // (*) 인덱스
    
    // (1) 등록 뷰
    
    // (2) 전체조회 뷰
    
}
