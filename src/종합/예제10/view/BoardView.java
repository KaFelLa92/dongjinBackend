package 종합.예제10.view;

import 종합.예제10.controller.BoardController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardView {
    // (*) 싱글톤
    private BoardView() {
    }

    public static final BoardView instance = new BoardView();

    public static BoardView getInstance() {
        return instance;
    }

    // (*) 입력 객체
    private Scanner scan = new Scanner(System.in);

    // (*) 메인 화면
    public void index() {
        for (; ; ) {
            try {
                System.out.println("============ 비회원 게시판 ============");
                System.out.println("1. 등록 | 2. 전체조회 | 3. 삭제 | 4. 수정");
                System.out.print("선택 >");
                int choose = scan.nextInt();
                if (choose == 1) {
                    boardWrite();
                } else if (choose == 2) {

                } else if (choose == 3) {

                } else if (choose == 4) {

                } else {
                    System.out.println("[경고] 존재하지 않는 번호입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[경고] 입력 타입이 일치하지 않습니다. < 다시입력해주세요. >");
                scan = new Scanner(System.in); // 입력에 따른 입력객체 초기화
            } catch (Exception e) {
                System.out.println("[오류] 관리자에게 문의하세요. 010-****-****");
            } // catch end
        } // for end
    } // func end

    // (*) 보드 컨트롤러 싱글톤 불러오기
    private BoardController boardController = BoardController.getInstance();

    // (1) 등록 화면 구현
    public void boardWrite() {
        // 1. 입력받기
        scan.nextLine();    // 넥스트라인 쓰려면 맨 앞에 하나 둬서 초기화
        System.out.print("> 내용 : ");
        String bcontent = scan.nextLine();
        System.out.print("> 작성자 : ");
        String bwriter = scan.next();
        // 2. controller 전달하기        // 3. 전달후 (결과)리턴값 저장하기
        boolean result = boardController.boardWrite(bcontent, bwriter);
        // 4. 리턴된 값에 따른 출력하기
        if (result) {
            System.out.println("[안내] 게시물 등록 성공");
        } else {
            System.out.println("[경고] 게시물 등록 실패");
        }


    }

} // class end
