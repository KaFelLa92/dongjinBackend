package 종합.예제8.view;

import 종합.예제8.controller.BoardController;
import 종합.예제8.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    // 1) 싱글톤 세팅
    private BoardView() {
    }

    public static final BoardView instance = new BoardView();

    public static BoardView getInstance() {
        return instance;
    }

    // 2) controller 싱글톤 가져오기
    private BoardController boardController = BoardController.getInstance();

    // * 모든 메소드에서 사용 가능한 Scanner 입력객체
    private Scanner scan = new Scanner(System.in);

    // * 프로그램 최초 화면
    public void index() {
        for (; ; ) {
            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int select = scan.nextInt();
            if(select == 1){
                addBoard();
            }
            if(select == 2){
                getBoardList();
            }
        }
    }

    // 3) 등록 입출력 구현
    public void addBoard() {
        // 1. 안내와 입력받기
        System.out.print("내용 : ");
        String content = scan.next();
        System.out.print("작성자 : ");
        String writer = scan.next();
        // 2. controller에게 입력받은 값 인수로 전달후 리턴받기
        boolean result = boardController.addBoard(content, writer);
        // 3. 결과/리턴 따른 출력문
        if (result) {
            System.out.println("[안내] 글쓰기 성공");
        } else {
            System.out.println("[경고] 글쓰기 실패");
        }

    }

    // 4) 전체조회 입출력 구현
    public void getBoardList() {
        // 1. controller에게 요청후 결과(리턴)받기
        ArrayList<BoardDto> result = boardController.getBoardList(); // view 메소드 먼저 작성시 controller 메소드가 없으므로 오류
        // 2. 받은 결과물들을 반복문 출력
        for (int i = 0; i < result.size(); i++) {
            BoardDto board = result.get(i);
            System.out.println("작성자 : " + board.getWriter());
            System.out.println("내용 : " + board.getContent());
            System.out.println("--------------------------------");
        }

    }

}
