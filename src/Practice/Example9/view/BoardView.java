package Practice.Example9.view;

import Practice.Example9.controller.BoardController;
import Practice.Example9.model.dto.BoardDto;

import java.util.ArrayList;
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
    public void index() {
        for ( ; ;){
            System.out.println("=======================");
            System.out.println("1. 등록 | 2. 전체조회");
            System.out.println("=======================");
            System.out.println("선택 >");
            int select = scan.nextInt();
            if (select == 1){
                boardWrite();
            } else if (select == 2) {
                boardPrint();
            }
        }
    } // index func end
    
    // (1) 등록 뷰
    public void boardWrite(){
        // 1. 입력
        scan.nextLine();
        System.out.println("내용 : ");
        String content = scan.nextLine();
        System.out.println("작성자 : ");
        String writer = scan.next();
        // 2. 컨트롤러에게 입력받은 값 전달
        boolean result = boardController.boardWrite(content , writer);
        // 3. 결과에 따른 출력
        if ( result ){
            System.out.println("게시물 등록 성공");
        } else {
            System.out.println("게시물 등록 실패");
        }
    } // func end
    
    // (2) 전체조회 뷰
    public void boardPrint() {
        // 1. 컨트롤러 요청 후 결과 받기
        ArrayList<BoardDto> result = boardController.boardPrint();
        // 2. 결과 반복 출력
        for (BoardDto dto : result){
            System.out.println("작성자 : " + dto.getWriter());
            System.out.println("내용 : " + dto.getContent());
            System.out.println("--------------------------");
        }
    } // func end
    
} // class end
